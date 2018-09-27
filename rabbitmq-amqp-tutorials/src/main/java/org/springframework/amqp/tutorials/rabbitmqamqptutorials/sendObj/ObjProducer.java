package org.springframework.amqp.tutorials.rabbitmqamqptutorials.sendObj;

import com.alibaba.fastjson.JSON;
import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class ObjProducer {

    @Autowired
    AmqpTemplate amqpTemplate;

//    @Scheduled(cron = "0/5 * * * * ?")
    public void sendObj(){
        User user = new User("lzx", "lzx");
        log.info(">>>>>" + JSON.toJSONString(user) + "<<<<<");
        amqpTemplate.convertAndSend("obj", user);
    }
}
