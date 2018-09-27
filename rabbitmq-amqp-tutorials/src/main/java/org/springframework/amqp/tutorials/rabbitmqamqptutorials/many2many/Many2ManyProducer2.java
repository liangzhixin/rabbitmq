package org.springframework.amqp.tutorials.rabbitmqamqptutorials.many2many;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 多对多模式:多个消息生产者
 */
@Component
@Slf4j
public class Many2ManyProducer2 {

    @Autowired
    AmqpTemplate amqpTemplate;

//    @Scheduled(cron = "0/3 * * * * ?")
    public void send(){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        String sendMsg = "producer2 hello many2many " + sdf.format(new Date());
        log.info("Producer2 : many2many producer sendMessage:" + sendMsg);
        amqpTemplate.convertAndSend("many2many", sendMsg);
    }
}
