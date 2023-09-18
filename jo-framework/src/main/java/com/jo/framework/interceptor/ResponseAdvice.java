package com.jo.framework.interceptor;

import com.alibaba.fastjson2.JSON;
import com.jo.common.core.domain.AjaxResult;
import org.springframework.core.MethodParameter;
import org.springframework.core.io.Resource;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.http.server.ServerHttpRequest;
import org.springframework.http.server.ServerHttpResponse;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyAdvice;

@RestControllerAdvice
public class ResponseAdvice implements ResponseBodyAdvice<Object> {
    @Override
    public boolean supports(MethodParameter methodParameter, Class<? extends HttpMessageConverter<?>> aClass) {
        //是否支持advice功能。true:支持，false:不支持
        return false;
    }

    @Override
    public Object beforeBodyWrite(Object obj, MethodParameter methodParameter, MediaType mediaType, Class<? extends HttpMessageConverter<?>> aClass, ServerHttpRequest serverHttpRequest, ServerHttpResponse serverHttpResponse) {
        if (obj instanceof String) {
            obj = AjaxResult.success(obj);
        } else if (!(obj instanceof Resource) && !(obj instanceof byte[]) && !(obj instanceof AjaxResult)) {
            obj = AjaxResult.success(obj);
        }
        return JSON.toJSONString(obj);
    }
}