package com.example.consumer;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "service-pro", fallback = HelloServiceFallBack.class) //fallback 配置熔断器，让服务调用的时候不会报错或无响应
public interface HelloService {

    @RequestMapping("/hello")
    String hello(@RequestParam String name);
}
