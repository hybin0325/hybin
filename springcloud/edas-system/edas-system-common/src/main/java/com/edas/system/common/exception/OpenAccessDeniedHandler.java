package com.edas.system.common.exception;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.web.access.AccessDeniedHandler;

import com.edas.system.common.model.ResultBody;
import com.edas.system.common.utils.WebUtils;

import lombok.extern.slf4j.Slf4j;

/**
 * 自定义访问拒绝
 * @author liuyadu
 */
@Slf4j
public class OpenAccessDeniedHandler implements AccessDeniedHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response,
                       AccessDeniedException exception) throws IOException, ServletException {
        ResultBody responseData = OpenExceptionHandler.resolveException(exception, request, response);
        WebUtils.writeJson(response, responseData);
    }
}