package net.medcrm.yjb.his.web.aggregator.filter;
import javax.servlet.http.HttpServletRequest;
import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import org.springframework.stereotype.Component;

/**
 * Created by asus on 2017/10/19.
 */
//@Component
public class AccessFilter extends ZuulFilter {

    @Override
    public String filterType() {
        return "pre";
    }
    @Override
    public int filterOrder() {
        return 0;
    }
    @Override
    public boolean shouldFilter() {
        return true;
    }

    /**
     * 访问拦截
     * @return
     */
    @Override
    public Object run() {
       /* RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        Object accessToken = request.getParameter("access_token");
        if(accessToken == null) {

            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(401);
            return null;
        }*/
        return null;
    }

}