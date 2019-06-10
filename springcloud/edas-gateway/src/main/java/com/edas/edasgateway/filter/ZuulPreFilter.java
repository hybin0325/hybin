package com.edas.edasgateway.filter;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cloud.netflix.zuul.filters.support.FilterConstants;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;

public class ZuulPreFilter extends ZuulFilter {

    /**
     * 是否应该执行该过滤器，如果是false，则不执行该filter
     */
    @Override
    public boolean shouldFilter() {
        return true;
    }

    //@Autowired
    //private MetricsEndpoint metricsEndpoint;
    //private static final String METRIC_NAME = "system.cpu.usage";
    //private static final double MAX_USAGE = 0.50D;

    /**
     * 过滤器类型
     * 顺序: pre ->routing -> post ,以上3个顺序出现异常时都可以触发error类型的filter
     */
    @Override
    public String filterType() {
        return FilterConstants.PRE_TYPE;
    }

    /**
     * 同filterType类型中，order值越大，优先级越低
     */
    @Override
    public int filterOrder() {
        return 1;
    }

    /**
     */
    @Override
    public Object run() {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();
        //HttpServletResponse response = ctx.getResponse();
        /*Double systemCpuUsage = metricsEndpoint.metric(METRIC_NAME, null)
                .getMeasurements()
                .stream()
                .filter(Objects::nonNull)
                .findFirst()
                .map(MetricsEndpoint.Sample::getValue)
                .filter(Double::isFinite)
                .orElse(0.0D);
        boolean ok = systemCpuUsage < MAX_USAGE;
        if (!ok) {
            response.setStatus(HttpStatus.TOO_MANY_REQUESTS.value());
            return null;
        }*/
        //log.info("send {} request to {}", request.getMethod(), request.getRequestURL().toString());

        String upgradeHeader = request.getHeader("Upgrade");
        if (null == upgradeHeader) {
            upgradeHeader = request.getHeader("upgrade");
        }
        if (null != upgradeHeader && "websocket".equalsIgnoreCase(upgradeHeader)) {
            ctx.addZuulRequestHeader("connection", "Upgrade");
        }

        System.out.println(String.format("%s ===== GatewayFilter ======= %s", request.getMethod(), request.getRequestURL().toString()));

        return null;
    }

}
