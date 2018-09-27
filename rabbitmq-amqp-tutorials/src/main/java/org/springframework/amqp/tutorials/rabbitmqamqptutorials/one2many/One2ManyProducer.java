package org.springframework.amqp.tutorials.rabbitmqamqptutorials.one2many;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 一对多模式:单个消息生产者
 */
@Component
@Slf4j
public class One2ManyProducer {

    @Autowired
    private AmqpTemplate amqpTemplate;

//    @Scheduled(cron = "0/3 * * * * ?")
    public void send(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String sendMsg = "hello one2many " + sdf.format(new Date());
        log.info("one2many producer sendMessage:" + sendMsg);
        amqpTemplate.convertAndSend("one2many", sendMsg);
    }
}
