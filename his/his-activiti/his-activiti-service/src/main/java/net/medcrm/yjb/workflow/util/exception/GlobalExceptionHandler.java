package net.medcrm.yjb.workflow.util.exception;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import net.medcrm.yjb.his.common.model.BaseResp;
import net.medcrm.yjb.his.common.model.ResultStatus;
import net.medcrm.yjb.workflow.util.StringUtils;

/**
 * 全局异常处理，捕获所有Controller中抛出的异常。
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	private Logger logger = LoggerFactory.getLogger(GlobalExceptionHandler.class);

	/**
	 * 系统异常处理，比如：404,401,500
	 * 
	 * @param req
	 * @param e
	 * @return
	 * @throws Exception
	 */
	@ExceptionHandler(value = Exception.class)
	@ResponseBody
	public BaseResp<?> defaultErrorHandler(HttpServletRequest req, Exception e) throws Exception {
		logger.error("", e);
		if(e instanceof AccessDeniedException){
			System.out.println(e.getMessage());
			return new BaseResp<>(ResultStatus.error_no_have__permission);
		}
		if (e instanceof org.springframework.web.servlet.NoHandlerFoundException) {
			return new BaseResp<String>(ResultStatus.http_status_not_found);
		} else {
			String ex=e.getMessage();
			
			if(StringUtils.isNotNull(ex)) {
				if ((ex.indexOf("invalid_token")> 0||ex.indexOf("unauthorized")> 0) || ex.indexOf("401") > 0) {
					return new BaseResp<>(ResultStatus.http_status_unauthorized);
				} 
			}
			return new BaseResp<>(ResultStatus.http_status_internal_server_error);
			
		}
	}
}
