package org.springframework.amqp.tutorials.rabbitmqamqptutorials.fanoutExchange;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FanoutSender {

    @Autowired
    AmqpTemplate amqpTemplate;

//    @Scheduled(cron = "0/5 * * * * ?")
    public void send(){
        String context = "hi, fanout msg.";
        log.info("Sender:" + context);
        amqpTemplate.convertAndSend("fanoutExchange", "", context);
    }

}
