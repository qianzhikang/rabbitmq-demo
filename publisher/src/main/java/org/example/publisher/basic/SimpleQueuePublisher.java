package org.example.publisher.basic;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @Description 简单发布者
 * @Date 2023-06-27-15-48
 * @Author qianzhikang
 */
@Component
public class SimpleQueuePublisher {
    @Autowired
    private RabbitTemplate rabbitTemplate;

    public void doPub(){
        // 队列名称
        String queueName = "simple.queue";
        // 消息
        String message = "hello, spring amqp!";
        // 声明队列
        rabbitTemplate.execute(channel -> {
            channel.queueDeclare(queueName, false, false, false, null);
            return null;
        });
        // 发送消息
        rabbitTemplate.convertAndSend(queueName, message);
    }
}
