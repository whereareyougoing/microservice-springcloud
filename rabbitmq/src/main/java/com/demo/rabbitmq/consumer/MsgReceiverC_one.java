package com.demo.rabbitmq.consumer;

import com.demo.rabbitmq.config.RabbitConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 宋艾衡
 * 2019/7/24 11:49
 */
@Component
@RabbitListener(queues = RabbitConfig.QUEUE_A)
@Slf4j
public class MsgReceiverC_one {

    /**
     * 比如一个生产者，多个消费者，可以写多个消费者，并且他们的分发是负载均衡的。
     * @param content
     */

    @RabbitHandler
    public void process(String content) {
        log.info("处理器one接收处理队列A当中的消息： " + content);
    }
}
