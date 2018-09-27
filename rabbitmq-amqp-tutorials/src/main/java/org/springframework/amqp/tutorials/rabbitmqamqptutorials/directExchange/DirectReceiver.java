package org.springframework.amqp.tutorials.rabbitmqamqptutorials.directExchange;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class DirectReceiver {

    @RabbitListener(queues = "direct.A")
    public void process1(String msg){
        log.info("Receiver from direct.A:" + msg);
    }

    @RabbitListener(queues = "direct.B")
    public void process2(String msg){
        log.info("Receiver from direct.B:" + msg);
    }
}
