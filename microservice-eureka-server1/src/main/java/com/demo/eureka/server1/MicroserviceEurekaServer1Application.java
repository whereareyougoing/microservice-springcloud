package com.demo.eureka.server1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class MicroserviceEurekaServer1Application {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceEurekaServer1Application.class, args);
    }

}
