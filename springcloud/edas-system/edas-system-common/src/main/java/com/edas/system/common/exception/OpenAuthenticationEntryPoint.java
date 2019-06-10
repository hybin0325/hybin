package com.edas.system.common.exception;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;

import com.edas.system.common.model.ResultBody;
import com.edas.system.common.utils.WebUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * 自定义未认证处理
 *
 * @author liuyadu
 */
@Slf4j
public class OpenAuthenticationEntryPoint implements AuthenticationEntryPoint {

    @Override
    public void commence(HttpServletRequest request, HttpServletResponse response,
                         AuthenticationException exception) throws IOException, ServletException {
        ResultBody responseData = OpenExceptionHandler.resolveException(exception, request, response);
        WebUtils.writeJson(response, responseData);
    }
}