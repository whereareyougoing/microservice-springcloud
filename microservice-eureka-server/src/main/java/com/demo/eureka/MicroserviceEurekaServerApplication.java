package com.demo.eureka;

import org.apache.activemq.command.ActiveMQQueue;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@SpringBootApplication(scanBasePackages = "com.demo.eureka")
@EnableScheduling
@EnableCaching
@MapperScan("com.demo.eureka.mapper")
@EnableTransactionManagement
@EnableEurekaServer
public class MicroserviceEurekaServerApplication {

    public static void main(String[] args) {
        SpringApplication.run(MicroserviceEurekaServerApplication.class, args);
    }


    @Bean
    public ActiveMQQueue queue() {
        return new ActiveMQQueue("active.queue");
    }
}
