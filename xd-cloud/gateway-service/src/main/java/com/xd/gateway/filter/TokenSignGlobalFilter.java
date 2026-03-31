package com.xd.gateway.filter;

import java.util.List;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

@Component
public class TokenSignGlobalFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String path = exchange.getRequest().getPath().value();
        List<String> whiteList = java.util.Arrays.asList("/auth/email/login", "/gateway/captcha/email/send", "/doc.html");

        if (whiteList.contains(path)) {
            return chain.filter(exchange);
        }

        String authorization = exchange.getRequest().getHeaders().getFirst("Authorization");
        String appId = exchange.getRequest().getHeaders().getFirst("X-App-Id");
        String sign = exchange.getRequest().getHeaders().getFirst("X-Sign");

        if (authorization == null || appId == null || sign == null) {
            exchange.getResponse().setStatusCode(HttpStatus.UNAUTHORIZED);
            return exchange.getResponse().setComplete();
        }

        // TODO: verify JWT, sign and nonce replay with Redis
        return chain.filter(exchange);
    }

    @Override
    public int getOrder() {
        return -100;
    }
}
