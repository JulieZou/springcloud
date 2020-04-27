package com.example.gateway.config;

import org.springframework.cloud.gateway.filter.ratelimit.KeyResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import reactor.core.publisher.Mono;

/**
 * 自定义限流策略
 */
@Configuration
public class CustomLimitingConfig {

    @Bean
    KeyResolver keyResolver() {

        //根据请求参数中的user来限流
        return exchange -> Mono.just(exchange.getRequest().getQueryParams().getFirst("user"));

        //根据请求的IP地址来限流
//       return exchange -> Mono.just(exchange.getRequest().getRemoteAddress().getHostName());
    }

}
