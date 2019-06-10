package com.edas.edasgateway.configurer;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.edas.edasgateway.filter.ZuulErrorFilter;
import com.edas.edasgateway.filter.ZuulLogsFilter;
import com.netflix.zuul.ZuulFilter;

@Configuration
public class EndpointConfiguration {

    @Bean
    public ZuulErrorFilter zuulErrorFilter() {
        return new ZuulErrorFilter();
    }

    @Bean
    public ZuulFilter preRequestLogFilter() {
        return new ZuulLogsFilter();
    }

}
