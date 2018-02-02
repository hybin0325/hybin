package net.medcrm.yjb.workflow.filter;

import net.medcrm.yjb.his.feign.AccessTokenLocal;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import javax.servlet.*;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * Created by lings on 2017/10/26.
 */
@Order(Ordered.HIGHEST_PRECEDENCE)
@Component
public class AccessFilter implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("init method");
    }

    @Override
    public void destroy() {
        System.out.println("destroy method");
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse res, FilterChain chain) throws IOException, ServletException {
        HttpServletResponse response = (HttpServletResponse) res;
        HttpServletRequest request = (HttpServletRequest) req;

        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "POST, GET, OPTIONS, DELETE");
        response.setHeader("Access-Control-Max-Age", "3600");
        // response.setHeader("Access-Control-Allow-Headers", "x-requested-with, authorization");
        response.setHeader("Access-Control-Allow-Headers", "x-requested-with,x-prototype-version, authorization, origin, content-type, accept");
        AccessTokenLocal.setCurrentLocalToken(request.getHeader("Authorization"));
        //response.setHeader("Access-Control-Allow-Headers", "Authentication,Origin, X-Requested-With, Content-Type, Accept");
        if ("OPTIONS".equalsIgnoreCase(request.getMethod())) {
            response.setStatus(HttpServletResponse.SC_OK);
        } else {
            chain.doFilter(req, res);
        }
    }
}
