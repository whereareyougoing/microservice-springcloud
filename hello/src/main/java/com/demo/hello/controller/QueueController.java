package com.demo.hello.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.jms.Queue;

/**
 * 宋艾衡
 * 2019/7/23 10:18
 */
@RestController
@RequestMapping
public class QueueController {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Autowired
    private Queue queue;

    @RequestMapping("/send")
    public void send(){
        jmsMessagingTemplate.convertAndSend(queue,"信发送的消息");
    }


}
