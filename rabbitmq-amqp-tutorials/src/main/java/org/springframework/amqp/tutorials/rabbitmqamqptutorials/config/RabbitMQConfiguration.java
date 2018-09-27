package org.springframework.amqp.tutorials.rabbitmqamqptutorials.config;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

    private static final String ONE2ONE = "one2one";
    private static final String ONE2MANY = "one2many";
    private static final String MANY2MANY = "many2many";
    private static final String OBJ = "obj";

    @Bean
    public Queue queueOne2One(){
        return new Queue(ONE2ONE);
    }

    @Bean
    public Queue queueOne2Many(){
        return new Queue(ONE2MANY);
    }

    @Bean
    public Queue queueMany2Many(){
        return new Queue(MANY2MANY);
    }

    @Bean
    public Queue queueObj(){
        return new Queue(OBJ);
    }

}
