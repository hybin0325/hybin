package com.edas.system.auth.advice;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.edas.system.auth.autoconfigure.LogAnnotation;
import com.edas.system.auth.entity.SysLogs;
import com.edas.system.auth.entity.SysUser;
import com.edas.system.auth.service.IUserService;
import com.edas.system.auth.service.SysLogService;
import com.edas.system.auth.utils.UserUtil;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;

/**
 * 统一日志处理
 *
 * @author hybin
 */
@Slf4j
@Aspect
@Component
public class LogAdvice {

	@Autowired
	private SysLogService logService;
	
	@Autowired
	private IUserService userService;

	@Around(value = "@annotation(com.edas.system.auth.autoconfigure.LogAnnotation)")
	public Object logSave(ProceedingJoinPoint joinPoint) throws Throwable {
		HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.getRequestAttributes()).getRequest();
		log.info("-----------------日志记录-----------------");
		String username = com.edas.system.common.utils.JwtUtil.getUserName(request,"123456");
		SysUser user= userService.getByUsername(username);
		SysLogs sysLogs = new SysLogs();
		sysLogs.setUser(user);
		
		MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
		
		//方法名
		String strMethodName=methodSignature.getName();
		sysLogs.setUrl(strMethodName);
		
		//参数
		Object[] params= methodSignature.getParameterNames();
		log.info("params {} "+params.toString());

		String module = null;
		LogAnnotation logAnnotation = methodSignature.getMethod().getDeclaredAnnotation(LogAnnotation.class);
		module = logAnnotation.module();
		if (StringUtils.isEmpty(module)) {
			ApiOperation apiOperation = methodSignature.getMethod().getDeclaredAnnotation(ApiOperation.class);
			if (apiOperation != null) {
				module = apiOperation.value();
			}
		}

		if (StringUtils.isEmpty(module)) {
			throw new RuntimeException("没有指定日志module");
		}
		sysLogs.setModule(module);
		log.info("module {} "+module);
		try {
			Object object = joinPoint.proceed();
			sysLogs.setFlag(true);

			return object;
		} catch (Exception e) {
			sysLogs.setFlag(false);
			sysLogs.setRemark(e.getMessage());
			throw e;
        } finally {
            if (sysLogs.getUser() != null) {
            	
                logService.save(sysLogs);
            }
        }

	}
}
