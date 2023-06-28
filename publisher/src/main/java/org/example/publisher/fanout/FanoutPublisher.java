package org.example.publisher.fanout;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Date 2023-06-27-16-47
 * @Author qianzhikang
 */
@Component
public class FanoutPublisher {

    @Resource
    private RabbitTemplate rabbitTemplate;

    public void doPub(){
        // 队列名称
        String exchangeName = "itcast.fanout";
        // 消息
        String message = "hello, everyone!";
        // 发送消息
        rabbitTemplate.convertAndSend(exchangeName,"", message);
    }
}
