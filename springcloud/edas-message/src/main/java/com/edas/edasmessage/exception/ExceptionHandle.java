package com.edas.edasmessage.exception;

import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.oauth2.provider.error.DefaultOAuth2ExceptionRenderer;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.UnsatisfiedServletRequestParameterException;
import org.springframework.web.method.annotation.MethodArgumentTypeMismatchException;

import com.edas.edascommon.exception.SystemErrorType;
import com.edas.edascommon.model.Result;

import lombok.extern.slf4j.Slf4j;
/**
 * 异常处理
 * @author nl
 *
 */
@Controller
@Slf4j
@RestControllerAdvice
public class ExceptionHandle {
	
	
	@ExceptionHandler({ IllegalArgumentException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Result badRequestException(IllegalArgumentException exception) {
		return Result.fail(SystemErrorType.BAD_REQUEST);
	}

	@ExceptionHandler({ AccessDeniedException.class})
	@ResponseStatus(HttpStatus.FORBIDDEN)
	public Result badRequestException(AccessDeniedException exception) {
		log.info("AccessDeniedException" +exception.getMessage());
		return Result.fail(SystemErrorType.FORBIDDEN);
	}
	


	@ExceptionHandler({ MissingServletRequestParameterException.class, HttpMessageNotReadableException.class,
			UnsatisfiedServletRequestParameterException.class, MethodArgumentTypeMismatchException.class })
	@ResponseStatus(HttpStatus.BAD_REQUEST)
	public Result badRequestException(Exception exception) {
		return Result.fail(SystemErrorType.BAD_REQUEST);
	}

	@ExceptionHandler(Throwable.class)
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	public Result exception(Throwable throwable) {
		log.error("系统异常", throwable);
		 return Result.fail();

	}
	
	@ExceptionHandler(RuntimeException.class)
	public Result handleException(Exception ex) {
		return Result.fail();
	}
	
	
}
