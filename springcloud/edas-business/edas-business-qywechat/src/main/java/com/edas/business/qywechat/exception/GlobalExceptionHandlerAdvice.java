package com.edas.business.qywechat.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.edas.edascommon.exception.DefaultGlobalExceptionHandlerAdvice;
import com.edas.edascommon.model.Result;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandlerAdvice extends DefaultGlobalExceptionHandlerAdvice {
	
	@SuppressWarnings("unchecked")
	@ExceptionHandler(value = {WxException.class})
    public Result<Object> baseException(WxException ex) {
        log.error("base exception:{}", ex.getMessage());
        return Result.fail(ex.getErrorType());
    }
	
}