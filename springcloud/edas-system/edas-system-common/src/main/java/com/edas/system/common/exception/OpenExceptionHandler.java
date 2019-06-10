package com.edas.system.common.exception;

import java.util.Locale;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.TypeMismatchException;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.authentication.AccountExpiredException;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.CredentialsExpiredException;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.authentication.LockedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.oauth2.common.exceptions.InvalidClientException;
import org.springframework.security.oauth2.common.exceptions.InvalidGrantException;
import org.springframework.security.oauth2.common.exceptions.InvalidRequestException;
import org.springframework.security.oauth2.common.exceptions.InvalidScopeException;
import org.springframework.security.oauth2.common.exceptions.InvalidTokenException;
import org.springframework.security.oauth2.common.exceptions.OAuth2Exception;
import org.springframework.security.oauth2.common.exceptions.RedirectMismatchException;
import org.springframework.security.oauth2.common.exceptions.UnauthorizedClientException;
import org.springframework.security.oauth2.common.exceptions.UnsupportedGrantTypeException;
import org.springframework.security.oauth2.common.exceptions.UnsupportedResponseTypeException;
import org.springframework.security.oauth2.common.exceptions.UserDeniedAuthorizationException;
import org.springframework.validation.BindingResult;
import org.springframework.web.HttpMediaTypeNotAcceptableException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.MissingServletRequestParameterException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.edas.system.common.constants.CommonConstants;
import com.edas.system.common.constants.ResultEnum;
import com.edas.system.common.model.ResultBody;
import com.edas.system.common.utils.SpringContextHolder;

import lombok.extern.slf4j.Slf4j;

/**
 * 统一异常处理器
 *
 * @author LYD
 * @date 2017/7/3
 */
@ControllerAdvice
@ResponseBody
@Slf4j
public class OpenExceptionHandler {
	/**
	 * 国际化配置
	 */
	private static Locale locale = LocaleContextHolder.getLocale();

	/**
	 * 统一异常处理 AuthenticationException
	 *
	 * @param ex
	 * @param request
	 * @param response
	 * @return
	 */
	@ExceptionHandler({ AuthenticationException.class })
	public static ResultBody authenticationException(Exception ex, HttpServletRequest request,
			HttpServletResponse response) {
		ResultEnum code = ResultEnum.ERROR;
		int httpStatus = HttpStatus.OK.value();
		if (ex instanceof UsernameNotFoundException) {
			code = ResultEnum.USERNAME_NOT_FOUND;
		} else if (ex instanceof BadCredentialsException) {
			code = ResultEnum.BAD_CREDENTIALS;
		} else if (ex instanceof AccountExpiredException) {
			code = ResultEnum.ACCOUNT_EXPIRED;
		} else if (ex instanceof LockedException) {
			code = ResultEnum.ACCOUNT_LOCKED;
		} else if (ex instanceof DisabledException) {
			code = ResultEnum.ACCOUNT_DISABLED;
		} else if (ex instanceof CredentialsExpiredException) {
			code = ResultEnum.CREDENTIALS_EXPIRED;
		} else if (ex instanceof InsufficientAuthenticationException) {
			code = ResultEnum.UNAUTHORIZED;
			httpStatus = HttpStatus.UNAUTHORIZED.value();
		}
		// 放入请求域
		request.setAttribute(CommonConstants.X_ERROR_CODE, code);
		return buildBody(ex, request, response, httpStatus);
	}

	/**
	 * OAuth2Exception
	 *
	 * @param ex
	 * @param request
	 * @param response
	 * @return
	 */
	@ExceptionHandler({ OAuth2Exception.class, InvalidTokenException.class })
	public static ResultBody oauth2Exception(Exception ex, HttpServletRequest request, HttpServletResponse response) {
		ResultEnum code = ResultEnum.UNAUTHORIZED;
		int httpStatus = HttpStatus.UNAUTHORIZED.value();
		if (ex instanceof InvalidClientException) {
			code = ResultEnum.INVALID_CLIENT;
		} else if (ex instanceof UnauthorizedClientException) {
			code = ResultEnum.UNAUTHORIZED_CLIENT;
		} else if (ex instanceof InvalidGrantException) {
			code = ResultEnum.INVALID_GRANT;
			if ("Bad credentials".equals(ex.getMessage())) {
				code = ResultEnum.BAD_CREDENTIALS;
				httpStatus = HttpStatus.OK.value();
			}
			if ("User is disabled".equals(ex.getMessage())) {
				code = ResultEnum.ACCOUNT_DISABLED;
				httpStatus = HttpStatus.OK.value();
			}
			if ("User account is locked".equals(ex.getMessage())) {
				code = ResultEnum.ACCOUNT_LOCKED;
				httpStatus = HttpStatus.OK.value();
			}
		} else if (ex instanceof InvalidScopeException) {
			code = ResultEnum.INVALID_SCOPE;
		} else if (ex instanceof InvalidTokenException) {
			code = ResultEnum.INVALID_TOKEN;
		} else if (ex instanceof InvalidRequestException) {
			code = ResultEnum.INVALID_REQUEST;
		} else if (ex instanceof RedirectMismatchException) {
			code = ResultEnum.REDIRECT_URI_MISMATCH;
		} else if (ex instanceof UnsupportedGrantTypeException) {
			code = ResultEnum.UNSUPPORTED_GRANT_TYPE;
		} else if (ex instanceof UnsupportedResponseTypeException) {
			code = ResultEnum.UNSUPPORTED_RESPONSE_TYPE;
		} else if (ex instanceof UserDeniedAuthorizationException) {
			code = ResultEnum.ACCESS_DENIED;
		} else {
			code = ResultEnum.INVALID_REQUEST;
		}
		if (code.equals(ResultEnum.ACCESS_DENIED)) {
			httpStatus = HttpStatus.FORBIDDEN.value();
		}
		// 放入请求域
		request.setAttribute(CommonConstants.X_ERROR_CODE, code);
		return buildBody(ex, request, response, httpStatus);
	}

	/**
	 * 自定义异常
	 *
	 * @param ex
	 * @param request
	 * @param response
	 * @return
	 */
	@ExceptionHandler({ OpenException.class })
	public static ResultBody openException(Exception ex, HttpServletRequest request, HttpServletResponse response) {
		ResultEnum code = ResultEnum.ERROR;
		int httpStatus = HttpStatus.OK.value();
		if (ex instanceof OpenAlertException) {
			code = ResultEnum.ALERT;
		}
		if (ex instanceof OpenSignatureException) {
			code = ResultEnum.SIGNATURE_DENIED;
		}
		// 放入请求域
		request.setAttribute(CommonConstants.X_ERROR_CODE, code);
		return buildBody(ex, request, response, httpStatus);
	}

	/**
	 * 其他异常
	 *
	 * @param ex
	 * @param request
	 * @param response
	 * @return
	 */
	@ExceptionHandler({ Exception.class })
	public static ResultBody exception(Exception ex, HttpServletRequest request, HttpServletResponse response) {
		ResultEnum code = ResultEnum.ERROR;
		int httpStatus = HttpStatus.INTERNAL_SERVER_ERROR.value();
		if (ex instanceof HttpMessageNotReadableException || ex instanceof TypeMismatchException
				|| ex instanceof MissingServletRequestParameterException) {
			httpStatus = HttpStatus.BAD_REQUEST.value();
			code = ResultEnum.BAD_REQUEST;
		} else if (ex instanceof NoHandlerFoundException) {
			httpStatus = HttpStatus.NOT_FOUND.value();
			code = ResultEnum.NOT_FOUND;
		} else if (ex instanceof HttpRequestMethodNotSupportedException) {
			httpStatus = HttpStatus.METHOD_NOT_ALLOWED.value();
			code = ResultEnum.METHOD_NOT_ALLOWED;
		} else if (ex instanceof HttpMediaTypeNotAcceptableException) {
			httpStatus = HttpStatus.BAD_REQUEST.value();
			code = ResultEnum.MEDIA_TYPE_NOT_ACCEPTABLE;
		} else if (ex instanceof MethodArgumentNotValidException) {
			BindingResult bindingResult = ((MethodArgumentNotValidException) ex).getBindingResult();
			code = ResultEnum.ALERT;
			return ResultBody.failed(code.getCode()+"", bindingResult.getFieldError().getDefaultMessage());
		} else if (ex instanceof IllegalArgumentException) {
			// 参数错误
			code = ResultEnum.ALERT;
			httpStatus = HttpStatus.BAD_REQUEST.value();
		} else if (ex instanceof AccessDeniedException) {
			code = ResultEnum.ACCESS_DENIED;
			Object accessDenied = request.getAttribute(CommonConstants.X_ACCESS_DENIED);
			if (accessDenied != null) {
				code = (ResultEnum) accessDenied;
			}
			httpStatus = HttpStatus.FORBIDDEN.value();
		}
		request.setAttribute(CommonConstants.X_ERROR_CODE, code);
		return buildBody(ex, request, response, httpStatus);
	}

	/**
	 * 静态解析异常。可以直接调用
	 *
	 * @param ex
	 * @param request
	 * @param response
	 * @return
	 */
	public static ResultBody resolveException(Exception ex, HttpServletRequest request, HttpServletResponse response) {
		ResultBody resultBody = null;
		if (ex instanceof AuthenticationException) {
			resultBody = authenticationException(ex, request, response);
		} else if (ex instanceof OAuth2Exception) {
			resultBody = oauth2Exception(ex, request, response);
		} else if (ex instanceof OpenException) {
			resultBody = openException(ex, request, response);
		} else {
			resultBody = exception(ex, request, response);
		}
		return resultBody;
	}

	/**
	 * 构建返回结果对象
	 *
	 * @param exception
	 * @param request
	 * @param response
	 * @return
	 */
	private static ResultBody buildBody(Exception exception, HttpServletRequest request, HttpServletResponse response,
			int httpStatus) {
		String path = request.getRequestURI();
		String method = request.getMethod();
		String message = exception.getMessage();
		ResultEnum resultCode = (ResultEnum) request.getAttribute(CommonConstants.X_ERROR_CODE);
		if (resultCode == null) {
			resultCode = ResultEnum.ERROR;
		}
		int code = resultCode.getCode();
		String error = resultCode.getMsg();
		// 提示信息
		String msgI18n = i18n(error, message);
		// 错误,放入请求域
		request.setAttribute(CommonConstants.X_ERROR, error);
		// 错误消息,放入请求域
		request.setAttribute(CommonConstants.X_ERROR_MESSAGE, msgI18n);
		// 状态码
		response.setStatus(httpStatus);
		log.error("==> 错误解析:method[{}] path[{}] code[{}] error[{}] message[{}] httpStatus[{}] exception{} ", method,
				path, code, error, msgI18n, httpStatus, exception);
		return ResultBody.failed(code+"", msgI18n,httpStatus);
	}

	/**
	 * 提示信息国际化
	 *
	 * @param error
	 * @param message
	 * @return
	 */
	private static String i18n(String error, String message) {
		MessageSource messageSource = SpringContextHolder.getBean(MessageSource.class);
		return messageSource.getMessage(error, null, message, locale);
	}
}
