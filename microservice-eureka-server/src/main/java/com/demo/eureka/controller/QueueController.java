package com.demo.eureka.controller;

import org.apache.activemq.command.ActiveMQQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 宋艾衡
 * @date 2019/5/23 14:44
 * @desc
 */

@RestController
public class QueueController {


    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @Autowired
    private ActiveMQQueue activeMQQueue;


    @RequestMapping("/send")
    public void send() {
        this.jmsMessagingTemplate.convertAndSend(this.activeMQQueue, "新发送的消息!");
    }

}
