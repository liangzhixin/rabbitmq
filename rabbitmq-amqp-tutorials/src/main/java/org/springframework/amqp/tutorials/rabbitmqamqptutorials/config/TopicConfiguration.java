package org.springframework.amqp.tutorials.rabbitmqamqptutorials.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TopicConfiguration {

    private static final String MESSAGE = "topic.message";
    private static final String MESSAGES = "topic.messages";

    @Bean
    public Queue queueMessage(){
        return new Queue(MESSAGE);
    }

    @Bean
    public Queue queueMessages(){
        return new Queue(MESSAGES);
    }

    @Bean
    public TopicExchange exchange(){
        return new TopicExchange("topicExchange");
    }

    @Bean
    public Binding bindingExchangeMessage(){
        return BindingBuilder.bind(queueMessage()).to(exchange()).with("topic.message");
    }

    @Bean
    public Binding bindingExchangeMessages(){
        return BindingBuilder.bind(queueMessages()).to(exchange()).with("topic.#");
    }

}
