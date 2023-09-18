package com.jo.web.controller.common;


import com.google.code.kaptcha.Producer;
import com.jo.common.constant.CacheConstants;
import com.jo.common.constant.Constants;
import com.jo.common.core.domain.po.SysLoginPo;
import com.jo.common.core.redis.RedisCache;
import com.jo.common.utils.LogUtils;
import com.jo.common.utils.MessageUtils;
import com.jo.common.utils.ServletUtils;
import com.jo.common.utils.StringUtils;
import com.jo.common.utils.ip.AddressUtils;
import com.jo.common.utils.ip.IpUtils;
import com.jo.common.utils.sign.Base64;
import com.jo.common.utils.spring.SpringUtils;
import com.jo.common.utils.uuid.IdUtils;
import com.jo.framework.manager.AsyncManager;
import com.jo.framework.manager.factory.AsyncFactory;
import com.jo.system.service.ISysLoginInfoService;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.FastByteArrayOutputStream;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.ImageIO;
import javax.servlet.http.HttpServletResponse;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.*;
import java.util.concurrent.TimeUnit;

/**
 * 验证码操作处理
 *
 * @author Joffrey
 */
@RestController
@RequestMapping("file/captcha")
public class CaptchaController {
    @Resource(name = "captchaProducer")
    private Producer captchaProducer;

    @Resource(name = "captchaProducerMath")
    private Producer captchaProducerMath;

    @Autowired
    private RedisCache redisCache;

    /**
     * 生成验证码
     */
    @GetMapping("/getCaptchaImage")
    public HashMap<String,Object> getCode(HttpServletResponse response) throws IOException {

        AsyncManager.me().execute(AsyncFactory.recordLoginInfo("usernameTest", Constants.LOGIN_FAIL,
                "msg123"));

        String uuid = IdUtils.simpleUUID();
        String verifyKey = CacheConstants.CAPTCHA_CODE_KEY + uuid;

        String capStr = null, code = null;
        BufferedImage image = null;

        // 生成验证码
        String capText = captchaProducerMath.createText();
        capStr = capText.substring(0, capText.lastIndexOf("@"));
        code = capText.substring(capText.lastIndexOf("@") + 1);
        image = captchaProducerMath.createImage(capStr);

        redisCache.setCacheObject(verifyKey, code, Constants.CAPTCHA_EXPIRATION, TimeUnit.MINUTES);
        // 转换流信息写出
        FastByteArrayOutputStream os = new FastByteArrayOutputStream();
        ImageIO.write(image, "jpg", os);
        HashMap<String,Object> returnObj = new HashMap<String,Object>();
        returnObj.put("uuid", uuid);
        returnObj.put("img", Base64.encode(os.toByteArray()));
        return returnObj;
    }
    @GetMapping("/haha")
    public String haha(){
        return "haha";
    }
}