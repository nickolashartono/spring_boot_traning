package com.example.testday1gw.filter;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.cloud.gateway.support.ServerWebExchangeUtils;
import org.springframework.stereotype.Component;

import org.springframework.web.server.ServerWebExchange;

import reactor.core.publisher.Mono;

@Component
public class LoggingGatewayFilter implements GlobalFilter{

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        String uuid = String.valueOf(UUID.randomUUID());
        logRequest(exchange, uuid);
        Long startTime = System.currentTimeMillis();
        return chain.filter(exchange).then(
            Mono.fromRunnable(() -> logResponse(exchange, uuid, startTime))
        );
    }

    private void logRequest(ServerWebExchange exchange, String uuid) {
        Object cachedBody = exchange.getAttributes().get(ServerWebExchangeUtils.CACHED_REQUEST_BODY_ATTR);
        System.out.println(getCurrentTimeStamp() + " - Request | ID: " + uuid + ", Path: " + exchange.getRequest().getPath()
                + ", Method: " + exchange.getRequest().getMethod() + ", Body: " + cachedBody);
    }

    private void logResponse(ServerWebExchange exchange, String uuid, Long startTime) {
        String body = "";
        System.out.println(getCurrentTimeStamp() + " - Response | ID: " + uuid + ", Path: " + exchange.getRequest().getPath()
                + ", Duration: " + (System.currentTimeMillis() - startTime) + " millis, Status: " + exchange.getResponse().getStatusCode()
                + ", Body: " + body);
    }
    
    public String getCurrentTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date now = new Date();
        return sdfDate.format(now);
    }
}
