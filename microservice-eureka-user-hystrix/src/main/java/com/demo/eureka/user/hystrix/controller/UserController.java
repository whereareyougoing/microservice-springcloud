package com.demo.eureka.user.hystrix.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @author 宋艾衡
 * @date 2019/5/23 16:43
 * @desc
 */

@RestController
public class UserController {



    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/findOrderById/{id}")
    @HystrixCommand(fallbackMethod = "fallbackInfo")
    public String findOrderById(@PathVariable Integer id){
        int orderId = 123;

//        return restTemplate.getForObject("http://localhost:7900/order/" + orderId, String.class);

        /**
         * 使用ribbon负载的之后，rest请求可以使用应用的名称进行请求
         */
        return restTemplate.getForObject("http://microservice-eureka-order/" + orderId, String.class);
    }


    public String fallbackInfo(@PathVariable Integer id){
        return "服务不可用，稍后再试";
    }


}
