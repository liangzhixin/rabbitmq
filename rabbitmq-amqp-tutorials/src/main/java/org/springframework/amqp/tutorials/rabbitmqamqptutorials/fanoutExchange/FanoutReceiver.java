package org.springframework.amqp.tutorials.rabbitmqamqptutorials.fanoutExchange;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FanoutReceiver {

    @RabbitListener(queues = "fanout.A")
    public void receiveA(String msg) {
        log.info("Receiver from fanout.A:" + msg);
    }

    @RabbitListener(queues = "fanout.B")
    public void receiveB(String msg) {
        log.info("Receiver from fanout.B:" + msg);
    }

    @RabbitListener(queues = "fanout.C")
    public void receiveC(String msg) {
        log.info("Receiver from fanout.C:" + msg);
    }
}
