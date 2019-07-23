package com.demo.produce.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.jms.Queue;
import javax.jms.Topic;


/**
 * 宋艾衡
 * 2019/7/23 16:54
 */

@RestController
@RequestMapping("/publish")
public class PublishController {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;
    @Resource
    private Queue queue;
    @Resource
    private Topic topic;

    @RequestMapping("/queue")
    public String queue(){
        for (int i = 0;i < 10; i++){
            jmsMessagingTemplate.convertAndSend(queue, "queue" + i);
        }
        return "queue消息发送成功！";
    }

    @RequestMapping("/topic")
    public String topic(){
        for (int i = 0;i<10;i++){
            jmsMessagingTemplate.convertAndSend(topic, "topic" + i);
        }
        return "topic消息发送成功";
    }

    @JmsListener(destination = "out.queue")
    public void receiveMsg(String message){
        System.out.println(message);
    }


}
