package com.example.logs;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.MDC;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.HandlerInterceptor;

public class MdcInterceptor implements HandlerInterceptor {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if(StringUtils.isEmpty(request.getHeader("CorrelationId"))) {
            MDC.put("CorrelationId", getCorrelationId());
        }else {
            MDC.put("CorrelationId", request.getHeader("CorrelationId"));
        }
        return true;
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        MDC.remove("CorrelationId");
    }

    private String getCorrelationId() {
        return UUID.randomUUID().toString();
    }
}