package org.example.publisher.direct;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @Description TODO
 * @Date 2023-06-28-08-44
 * @Author qianzhikang
 */
@Component
public class DirectPublisher {

    @Resource
    private RabbitTemplate rabbitTemplate;

    public void doPub(){
        // 交换机名称
        String exchangeName = "itcast.direct";
        // 消息
        String message = "红色警报！日本乱排核废水，导致海洋生物变异，惊现哥斯拉！";
        // 发送消息
        //rabbitTemplate.convertAndSend(exchangeName, "red", message);
        rabbitTemplate.convertAndSend(exchangeName, "green", message);
        //rabbitTemplate.convertAndSend(exchangeName, "yellow", message);
    }
}
