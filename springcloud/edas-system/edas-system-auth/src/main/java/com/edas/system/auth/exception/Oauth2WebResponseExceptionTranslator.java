package com.edas.system.auth.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.security.oauth2.provider.error.WebResponseExceptionTranslator;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import com.edas.system.common.exception.OpenExceptionHandler;
import com.edas.system.common.model.ResultBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 自定义oauth2异常提示
 * @author hybin
 */
@Slf4j
@Component
public class Oauth2WebResponseExceptionTranslator implements WebResponseExceptionTranslator {

    @Override
    public ResponseEntity translate(Exception e) throws Exception {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
        HttpServletResponse response = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getResponse();
        ResultBody responseData = OpenExceptionHandler.resolveException(e, request, response);
        return ResponseEntity.status(responseData.getHttpStatus()).body(responseData);
    }
}
