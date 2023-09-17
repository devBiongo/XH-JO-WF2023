package com.jo.framework.security.handle;

import com.alibaba.fastjson2.JSON;
import com.jo.common.core.domain.AjaxResult;
import com.jo.common.utils.ServletUtils;
import com.jo.common.utils.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class AccessDeniedHandlerImpl implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException accessDeniedException) throws IOException, ServletException {
        String msg = StringUtils.format("请求访问：{}，您的权限不足，请获取更高级别的访问权限。", request.getRequestURI());
        ServletUtils.renderString(response, JSON.toJSONString(AjaxResult.error(HttpStatus.FORBIDDEN.value(), msg)));
        response.setStatus(HttpStatus.FORBIDDEN.value());
    }
}