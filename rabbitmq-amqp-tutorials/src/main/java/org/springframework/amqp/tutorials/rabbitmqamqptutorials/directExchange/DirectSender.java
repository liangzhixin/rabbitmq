package org.springframework.amqp.tutorials.rabbitmqamqptutorials.directExchange;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DirectSender {

    @Autowired
    AmqpTemplate amqpTemplate;

//    @Scheduled(cron = "0/5 * * * * ?")
    public void send1(){
        String context = "hi, direct msg ";
        log.info("Sender:" + context);
        amqpTemplate.convertAndSend("directExchange", "info", context);
    }

//    @Scheduled(cron = "0/5 * * * * ?")
    public void send2(){
        String context = "hi, direct msg ";
        log.info("Sender:" + context);
        amqpTemplate.convertAndSend("directExchange", "warning", context);
    }

//    @Scheduled(cron = "0/5 * * * * ?")
    public void send3(){
        String context = "hi, direct msg ";
        log.info("Sender:" + context);
        amqpTemplate.convertAndSend("directExchange", "error", context);
    }
}
