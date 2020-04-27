package com.example.hystrix;

import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestParam;

@Component
public class HelloServiceFallBack implements HelloService {
    @Override
    public String hello(@RequestParam("name") String name) {

        return "Hello " + name + ", I'am fallback message";
    }
}
