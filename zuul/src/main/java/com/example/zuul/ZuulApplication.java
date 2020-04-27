package com.example.zuul;

import com.example.zuul.filter.CustomTokenZuulFilter;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableZuulProxy
@EnableEurekaClient
public class ZuulApplication {

    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class, args);
    }

    /**
     * 增加自定义token过滤器验证，例如：
     * 访问路径为：http://localhost:8087/service-pro/hello?name=spring
     * 访问结果：请求参数中未带有token 因此不能访问资源。通过熔断器来处理这一不予访问的请求（ProducerFallback ）
     *
     * 访问路径为：http://localhsot:8087/service-pro/hello?name=spring&token=aaa
     * 访问结果：请求参数中带有token，给予访问
     * @return
     */
    @Bean
    public CustomTokenZuulFilter tokenZuulFilter() {
        return new CustomTokenZuulFilter();
    }
}
