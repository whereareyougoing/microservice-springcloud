package com.demo.eureka.controller;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 宋艾衡
 * @date 2019/5/23 14:48
 * @desc
 */

@RestController
public class CustomerController {


    @JmsListener(destination = "active.queue")
    public void receive(String message) {
        System.out.println("接收到消息为：" + message);
    }

}
