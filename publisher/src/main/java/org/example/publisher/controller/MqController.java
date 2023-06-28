package org.example.publisher.controller;

import org.example.publisher.basic.SimpleQueuePublisher;
import org.example.publisher.direct.DirectPublisher;
import org.example.publisher.fanout.FanoutPublisher;
import org.example.publisher.topic.TopicPublisher;
import org.example.publisher.work.WorkPublisher;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @Description 请求
 * @Date 2023-06-27-15-50
 * @Author qianzhikang
 */
@RestController
public class MqController {

    @Resource
    private SimpleQueuePublisher simpleQueuePublisher;

    @Resource
    private WorkPublisher workPublisher;

    @Resource
    private FanoutPublisher fanoutPublisher;

    @Resource
    private DirectPublisher directPublisher;

    @Resource
    private TopicPublisher topicPublisher;

    @GetMapping("/basic")
    public String basic(){
        simpleQueuePublisher.doPub();
        return "简单队列发送测试！";
    }

    @GetMapping("/work")
    public String work() throws InterruptedException {
        workPublisher.doPub();
        return "任务队列发送测试！";
    }

    @GetMapping("/fanout")
    public String fanout() {
        fanoutPublisher.doPub();
        return "广播队列发送测试！";
    }

    @GetMapping("/direct")
    public String direct() {
        directPublisher.doPub();
        return "路由队列发送测试！";
    }

    @GetMapping("/topic")
    public String topic(){
        topicPublisher.doPub();
        return "主题队列发送测试！";
    }
}
