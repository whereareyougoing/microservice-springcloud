package com.demo.consumer.controller;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

/**
 * 宋艾衡
 * 2019/7/23 17:21
 */
@Component
public class TopicListener {

    @JmsListener(destination = "publish.topic", containerFactory = "jmsListenerContainerTopic")
    public void receive(String message){
        System.out.println("TopicListener: consumer-a 收到一条信息: " + message);
    }

}
