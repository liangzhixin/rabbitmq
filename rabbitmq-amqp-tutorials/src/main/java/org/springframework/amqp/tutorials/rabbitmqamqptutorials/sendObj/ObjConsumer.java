package org.springframework.amqp.tutorials.rabbitmqamqptutorials.sendObj;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "obj")
@Slf4j
public class ObjConsumer {

    @RabbitHandler
    public void process(User user){
        log.info("receive:" + JSON.toJSONString(user));
    }
}
