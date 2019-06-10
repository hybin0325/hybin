package com.edas.business.byrobot.exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.edas.edascommon.exception.DefaultGlobalExceptionHandlerAdvice;
import com.edas.edascommon.model.Result;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandlerAdvice extends DefaultGlobalExceptionHandlerAdvice {
	
	
	@SuppressWarnings("unchecked")
	@ExceptionHandler(value = {MethodArgumentNotValidException.class})
    public Result<Object> serviceException(MethodArgumentNotValidException ex) {
		//获取参数校验错误集合
        List<FieldError> fieldErrors = ex.getBindingResult().getFieldErrors();
        //格式化以提供友好的错误提示
        String data = String.format("参数校验错误（%s）：%s", fieldErrors.size(),
                fieldErrors.stream()
                .map(FieldError::getDefaultMessage)
                .collect(Collectors.joining(";")));
        log.error("service exception:{}", data);
        return Result.fail("020000", data);
    }
}