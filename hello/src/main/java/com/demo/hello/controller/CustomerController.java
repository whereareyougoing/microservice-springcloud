package com.demo.hello.controller;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.web.bind.annotation.RestController;

/**
 * 宋艾衡
 * 2019/7/23 10:21
 */

@RestController
public class CustomerController {


    @JmsListener(destination = "active.queue")
    public void readActiveQueue(String message){
        System.out.println("接收到的消息为："+message);
    }

}
