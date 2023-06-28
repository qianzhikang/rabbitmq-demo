package org.example.consumer.basic;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @Description 简单消费者
 * @Date 2023-06-27-15-47
 * @Author qianzhikang
 */
@Component
public class SimpleQueueConsumer {
    /**
     * 注：在启动之前，需要先执行对应的请求创建队列，不然会报错
     * @param msg 消息
     */
    @RabbitListener(queues = "simple.queue")
    public void listenSimpleQueueMessage(String msg) {
        System.out.println("spring 消费者接收到消息：【" + msg + "】");
    }
}
