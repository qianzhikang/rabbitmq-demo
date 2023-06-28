package org.example.publisher.work;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Description 多个消费者绑定到一个队列，共同消费队列中的消息--广播模式
 * @Date 2023-06-27-16-30
 * @Author qianzhikang
 */
@Component
public class WorkPublisher {
    @Resource
    RabbitTemplate rabbitTemplate;

    public void doPub() throws InterruptedException {
        // 队列名称
        String queueName = "work.queue";
        // 消息
        String message = "hello, message_";
        // 声明队列
        rabbitTemplate.execute(channel -> {
            channel.queueDeclare(queueName, false, false, false, null);
            return null;
        });
        for (int i = 0; i < 50; i++) {
            // 发送消息
            rabbitTemplate.convertAndSend(queueName, message + i);
            Thread.sleep(20);
        }
    }
}
