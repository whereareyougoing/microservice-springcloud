package com.demo.produce.config;


import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;

import javax.jms.Queue;
import javax.jms.Topic;

/**
 * 宋艾衡
 * 2019/7/23 16:27
 */
@Configuration
public class ActiveMQConfig {


    @Value("${queueName}")
    private String queueName;

    @Value("${topicName}")
    private String topicName;

    @Value("${spring.activemq.user}")
    private String username;

    @Value("${spring.activemq.password}")
    private String password;

    @Value("${spring.activemq.broker-url}")
    private String brokerUrl;

    @Bean
    public Queue quere(){
        return new ActiveMQQueue(queueName);
    }

    @Bean
    public Topic topic(){
        return new ActiveMQTopic(topicName);
    }

    @Bean
    public ActiveMQConnectionFactory connectionFactory(){
        return new ActiveMQConnectionFactory(username, password, brokerUrl);
    }

    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerQueue(ActiveMQConnectionFactory factory){
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        bean.setConnectionFactory(factory);
        return bean;
    }

    // 这个地方使用bean注解的方法名会作为bean的名字放入到spring容器中
    @Bean
    public JmsListenerContainerFactory<?> jmsListenerContainerTopic(ActiveMQConnectionFactory factory){
        DefaultJmsListenerContainerFactory bean = new DefaultJmsListenerContainerFactory();
        //设置为发布订阅方式, 默认情况下使用的生产消费者方式
        bean.setPubSubDomain(true);
        bean.setConnectionFactory(factory);
        return bean;
    }



}
