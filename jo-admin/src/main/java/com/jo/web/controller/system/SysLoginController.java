package com.jo.web.controller.system;

import com.jo.common.constant.Constants;
import com.jo.common.core.domain.AjaxResult;
import com.jo.common.core.domain.po.SysUserPo;
import com.jo.common.core.model.LoginBody;
import com.jo.common.utils.SecurityUtils;
import com.jo.framework.web.service.SysLoginService;
import com.jo.framework.web.service.SysPermissionService;
import com.jo.system.service.ISysMenuService;
import com.jo.system.service.ISysUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

/**
 * 登录验证
 *
 * @author ruoyi
 */
@RestController
public class SysLoginController {
    @Autowired
    private SysLoginService loginService;

    @Autowired
    private ISysMenuService menuService;

    @Autowired
    private SysPermissionService permissionService;

    @Autowired
    private ISysUserService sysUserService;

    @GetMapping("/test")
    public List<SysUserPo> test() {

        List<SysUserPo> list = sysUserService.list();
        return list;

    }


    /**
     * 登录方法
     *
     * @param loginBody 登录信息
     * @return 结果
     */
    @PostMapping("/login")
    public AjaxResult login(@RequestBody LoginBody loginBody) {
        AjaxResult ajax = AjaxResult.success();
        // 生成令牌
        String token = loginService.login(loginBody.getUsername(), loginBody.getPassword(), loginBody.getCode(),
                loginBody.getUuid());
        ajax.put(Constants.TOKEN, token);
        return ajax;
    }


}
