package com.jo.web.param;

import lombok.Data;

import javax.validation.constraints.NotBlank;

/**
 * 用户登录对象
 *
 * @author ruoyi
 */
@Data
public class LoginParam {

    /**
     * 唯一标识
     */
    private String uuid;

    /**
     * 用户名
     */
    @NotBlank
    private String username;

    /**
     * 用户密码
     */
    @NotBlank
    private String password;

    /**
     * 验证码
     */
    private String code;


}
