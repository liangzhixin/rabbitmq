package org.springframework.amqp.tutorials.rabbitmqamqptutorials.one2one;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 一个生产者对应一个消费者:生产者
 */
@Component
@Slf4j
public class OneProducer {

    @Autowired
    private AmqpTemplate amqpTemplate;

//    @Scheduled(cron = "0/3 * * * * ?")
    public void send(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String sendMsg = "hello one2one " + sdf.format(new Date());
        log.info("one2one producer sendMessage:" + sendMsg);
        amqpTemplate.convertAndSend("one2one",sendMsg);
    }
}



