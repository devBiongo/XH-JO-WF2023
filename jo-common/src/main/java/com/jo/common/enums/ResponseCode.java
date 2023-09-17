package com.jo.common.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public enum ResponseCode {
    SUCCESS(200, "success"),
    FAIL(500, "failed"),
    HTTP_STATUS_200(200, "ok"),
    HTTP_STATUS_400(400, "request error"),
    HTTP_STATUS_401(401, "no authentication"),
    HTTP_STATUS_403(403, "no authorities"),
    HTTP_STATUS_404(404, "path not found"),
    HTTP_STATUS_500(500, "server error"),
    INVALID_TOKEN(2001, "访问令牌不合法"),
    ACCESS_DENIED(2003, "没有权限访问该资源"),
    CLIENT_AUTHENTICATION_FAILED(1001, "客户端认证失败"),
    USERNAME_OR_PASSWORD_ERROR(1002, "用户名或密码错误"),
    UNSUPPORTED_GRANT_TYPE(1003, "不支持的认证模式"),
    BUSINESS_ERROR(3001, "业务出错");
    public static final List<ResponseCode> HTTP_STATUS_ALL
            = List.of(HTTP_STATUS_200, HTTP_STATUS_400, HTTP_STATUS_401, HTTP_STATUS_403, HTTP_STATUS_500);
    /**
     * response code
     */
    private final int code;

    /**
     * description.
     */
    private final String description;
}