package org.springframework.amqp.tutorials.rabbitmqamqptutorials.many2many;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 一对多模式:多个消费者
 */
@Component
@RabbitListener(queues = "many2many")
@Slf4j
public class Many2ManyConsumer2 {

    @RabbitHandler
    public void process(String msg){
        log.info("Consumer2 : many2many consumer receive:" + msg);
    }
}
