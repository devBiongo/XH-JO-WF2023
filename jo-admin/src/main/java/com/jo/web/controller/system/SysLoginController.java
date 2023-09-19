package com.jo.web.controller.system;

import com.jo.common.constant.Constants;
import com.jo.common.core.domain.AjaxResult;
import com.jo.web.param.LoginParam;
import com.jo.framework.web.service.SysLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * 登录验证
 *
 * @author ruoyi
 */
@RestController
public class SysLoginController {

    @Autowired
    private SysLoginService loginService;

    /**
     * 登录方法
     *
     * @param loginParam 登录信息
     * @return 结果
     */
    @PostMapping("/login")
    public AjaxResult login(@RequestBody @Validated LoginParam loginParam) {
        // 生成令牌
        String token = loginService.login(loginParam.getUsername(), loginParam.getPassword(), loginParam.getCode(),
                loginParam.getUuid());
        Map<String,String> data = new HashMap<>(){{
            put(Constants.TOKEN, token);
        }};
        return AjaxResult.success(data);
    }


}
