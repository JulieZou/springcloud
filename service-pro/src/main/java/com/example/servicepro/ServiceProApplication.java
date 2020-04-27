package com.example.servicepro;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;

/**
 * @EnableEurekaClient和@EnableDiscoveryClient的异同
 * @EnableDiscoveryClient有多种实现，比如：eureka, consul, zookeeper
 * 但是使用@EnableEurekaClient的话只能发现Eureka的注册服务
 */
@EnableEurekaClient
@SpringBootApplication
public class ServiceProApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceProApplication.class, args);
    }

}
