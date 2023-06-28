package org.example.publisher.topic;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Description 主题发布
 * @Date 2023-06-28-08-58
 * @Author qianzhikang
 */
@Component
public class TopicPublisher {
    @Resource
    private RabbitTemplate rabbitTemplate;

    public void doPub() {
        // 交换机名称
        String exchangeName = "itcast.topic";
        // 消息
        String message = "喜报！孙悟空大战哥斯拉，胜!";
        // 发送消息
        rabbitTemplate.convertAndSend(exchangeName, "china.news", message);
    }
}
