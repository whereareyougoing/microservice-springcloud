package com.demo.eureka.user;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@EnableEurekaClient
public class MicroserviceEurekaUserApplication {


    /**
     * loadbalance是ribbon使用的注解，ribbon是默认在eureka所以不用再次引入
     */
    @Bean
    @LoadBalanced
    public RestTemplate restTemplate(){

        // restTemplate是spring提供的用于访问rest客户端的实例
        return new RestTemplate();
    }

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceEurekaUserApplication.class, args);
    }

}
