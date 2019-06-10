package com.edas.edasgateway.filter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

/**
 * zuul代理前置过滤器
 */
public class ZuulLogsFilter extends ZuulFilter {

    /**
     * 是否应该执行该过滤器，如果是false，则不执行该filter
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 过滤器类型
     * 顺序: pre ->routing -> post ,以上3个顺序出现异常时都可以触发error类型的filter
     */
    @Override
    public String filterType() {
        return FilterConstants.POST_TYPE;
    }

    /**
     * 同filterType类型中，order值越大，优先级越低
     */
    @Override
    public int filterOrder() {
        return FilterConstants.PRE_DECORATION_FILTER_ORDER + 2;
    }

    /**
     */
    @SuppressWarnings("unused")
	@Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        HttpServletResponse response = ctx.getResponse();
        try {
            //accessLogsService.addLogs(ctx);
            System.out.println(" === ZuulLogsFilter == ");
        } catch (Exception e) {
            //log.error("添加访问日志异常:",e);
        }
        return null;
    }

}
