package org.springframework.amqp.tutorials.rabbitmqamqptutorials.topicExchange;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TopicReceive {

    @RabbitListener(queues = "topic.message")
    public void process1(String msg){
        log.info("Receiver1:" + msg);
    }

    @RabbitListener(queues = "topic.messages")
    public void process2(String msg){
        log.info("Receiver2:" + msg);
    }
}
