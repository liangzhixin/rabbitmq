package org.springframework.amqp.tutorials.rabbitmqamqptutorials.one2one;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * 一个生产者对应一个消费者:消费者
 */
@Component
@RabbitListener(queues = "one2one")
@Slf4j
public class OneConsumer {

    @RabbitHandler
    public void process(String hello){
        log.info("process : one2one consumer receive:" + hello);
    }

    @RabbitListener(queues = "one2one")
    public void process2(String hello){
        log.info("process2 : one2one consumer receive:" + hello);
    }

}
