package com.demo.consumer.controller;

import org.springframework.jms.annotation.JmsListener;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Component;

/**
 * 宋艾衡
 * 2019/7/23 17:11
 */
@Component
public class QueueListener {

    @JmsListener(destination = "publish.queue",containerFactory = "jmsListenerContainerQueue")
    @SendTo("out.queue")  // 将方法中返回的数据加入到队列中
    public String receive(String message){
        System.out.println("QueueListener: consumer-a 收到一条信息: " + message);
        return "consumer-a received : " + message;
    }

}
