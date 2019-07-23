package com.demo.hello;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;

import javax.jms.Queue;

@SpringBootApplication
@EnableCaching
public class HelloApplication {

    @Bean
    public Queue quere(){
        return new ActiveMQQueue("active.queue");
    }

    public static void main(String[] args) {
        SpringApplication.run(HelloApplication.class, args);
    }

}
