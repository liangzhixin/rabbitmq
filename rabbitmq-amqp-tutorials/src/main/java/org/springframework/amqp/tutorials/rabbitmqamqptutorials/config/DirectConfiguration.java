package org.springframework.amqp.tutorials.rabbitmqamqptutorials.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DirectConfiguration {

    @Bean
    public Queue queueDirectA(){
        return new Queue("direct.A");
    }

    @Bean
    public Queue queueDirectB() {
        return new Queue("direct.B");
    }

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("directExchange");
    }

    @Bean
    public Binding bindingDirectExchangeA(){
        return BindingBuilder.bind(queueDirectA()).to(directExchange()).with("error");
    }

    @Bean
    public Binding bindingDirectExchangeB1(){
        return BindingBuilder.bind(queueDirectB()).to(directExchange()).with("info");
    }

    @Bean
    public Binding bindingDirectExchangeB2(){
        return BindingBuilder.bind(queueDirectB()).to(directExchange()).with("warning");
    }

    @Bean
    public Binding bindingDirectExchangeB3(){
        return BindingBuilder.bind(queueDirectB()).to(directExchange()).with("error");
    }

}
