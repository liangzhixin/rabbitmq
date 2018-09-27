package org.springframework.amqp.tutorials.rabbitmqamqptutorials.topicExchange;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class TopicSender {

    @Autowired
    AmqpTemplate amqpTemplate;

//    @Scheduled(cron = "0/5 * * * * ?")
    public void send1(){
        String context = "hi, i am message 1";
        log.info("Sender:" + context);
        amqpTemplate.convertAndSend("topicExchange","topic.message", context);
    }

//    @Scheduled(cron = "0/5 * * * * ?")
    public void send2(){
        String context = "hi. i am messages 2";
        log.info("Sender:" + context);
        amqpTemplate.convertAndSend("topicExchange", "topic.messages", context);
    }
}
