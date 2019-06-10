package com.edas.edasgateway.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import com.edas.edascommon.utils.StringUtils;
import com.edas.system.common.constants.ResultEnum;
import com.edas.system.common.exception.OpenExceptionHandler;
import com.edas.system.common.exception.OpenMessageException;
import com.edas.system.common.model.ResultBody;
import com.edas.system.common.utils.WebUtils;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * zuul错误响应过滤器
 */

public class ZuulErrorFilter extends ZuulFilter {

	@Override
	public String filterType() {
		return FilterConstants.ERROR_TYPE;
	}

	@Override
	public int filterOrder() {
		return -1;
	}

	@Override
	public boolean shouldFilter() {
		return true;
	}

	@Override
	public Object run() {
		RequestContext ctx = RequestContext.getCurrentContext();
		HttpServletRequest request = ctx.getRequest();
		HttpServletResponse response = ctx.getResponse();
		Throwable throwable = ctx.getThrowable();
		Exception ex = (Exception) throwable;

		if (StringUtils.toBoolean(ctx.get("rateLimitExceeded"))) {
			ex = new OpenMessageException(ResultEnum.TOO_MANY_REQUEST.getCode(), ResultEnum.TOO_MANY_REQUEST.getMsg());
		}
		try {
			// accessLogsService.addLogs(ctx);
			System.out.println(" === ZuulErrorFilter == ");

		} catch (Exception e) {
			// log.error("添加访问日志异常:", e);
			System.out.println("=== ZuulErrorFilter===" + e.getMessage());
		}
		@SuppressWarnings("rawtypes")
		ResultBody responseData = OpenExceptionHandler.resolveException(ex, request, response);
		WebUtils.writeJson(ctx.getResponse(), responseData);
		return null;
	}

	
}
