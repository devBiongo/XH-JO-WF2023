package com.jo.framework.security.handle;

import com.alibaba.fastjson2.JSON;
import com.jo.common.core.domain.AjaxResult;
import com.jo.common.utils.ServletUtils;
import com.jo.common.utils.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class AuthenticationEntryPointImpl implements AuthenticationEntryPoint {
    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response, AuthenticationException e){
        String msg = StringUtils.format("请求访问：{}，认证失败，无法访问系统资源", request.getRequestURI());
        ServletUtils.renderString(response, JSON.toJSONString(AjaxResult.error(HttpStatus.UNAUTHORIZED.value(), msg)));
        response.setStatus(HttpStatus.UNAUTHORIZED.value());
    }
}