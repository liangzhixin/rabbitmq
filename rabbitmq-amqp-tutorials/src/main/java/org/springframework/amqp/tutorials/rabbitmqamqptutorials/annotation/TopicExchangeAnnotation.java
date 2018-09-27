package org.springframework.amqp.tutorials.rabbitmqamqptutorials.annotation;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.Exchange;
import org.springframework.amqp.rabbit.annotation.Queue;
import org.springframework.amqp.rabbit.annotation.QueueBinding;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

//@Component
@Slf4j
public class TopicExchangeAnnotation {

    @Value("${spring.boot.exchange}")
    private String exchange;

    @Value("${spring.boot.bind.key}")
    private String bindKey;

    @Value("${spring.boot.other.bind.key}")
    private String otherBindKey;

    @Autowired
    private AmqpTemplate amqpTemplate;

    @Scheduled(cron = "0/3 * * * * ?")
    public void send(){
        String msg = "hello world!";
        log.info("send:" + msg);
//        amqpTemplate.convertAndSend(exchange, bindKey, msg);
        amqpTemplate.convertAndSend(exchange, otherBindKey, msg);
    }


    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue(value = "${spring.boot.queue}", durable = "true", autoDelete = "true"),
                exchange = @Exchange(value = "${spring.boot.exchange}", type = ExchangeTypes.TOPIC),
                key = {"${spring.boot.bind.key}"}
            )
    })
    public void process(String msg){
        log.info("process receive:" + msg);
    }

    @RabbitListener(bindings = {
            @QueueBinding(value = @Queue(value = "${spring.boot.other.queue}", durable = "true", autoDelete = "true"),
                    exchange = @Exchange(value = "${spring.boot.exchange}", type = ExchangeTypes.TOPIC),
                    key = {"#"}
            )
    })
    public void process2(String msg){
        log.info("process2 receive:" + msg);
    }
}
