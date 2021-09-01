package com.insis.defense.cmd.infrastructure.rabbit;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfig {

    @Value("${insis.rabbitmq.defense.exchange}")
    private String defenseExchange;

    @Bean
    FanoutExchange defenseExchange() {
        return new FanoutExchange(defenseExchange);
    }

    @Value("${insis.rabbitmq.defense.created.queue}")
    private String defenseCreatedQueue;

    @Value("${insis.rabbitmq.defense.updated.queue}")
    private String defenseUpdatedQueue;

    @Value("${insis.rabbitmq.defense.delete.queue}")
    private String defenseDeleteQueue;

    @Bean
    public Queue defenseCreatedQueue() {
        return new Queue(defenseCreatedQueue);
    }

    @Bean
    public Queue defenseUpdatedQueue() {
        return new Queue(defenseUpdatedQueue);
    }

    @Bean
    public Queue defenseDeleteQueue() {
        return new Queue(defenseDeleteQueue);
    }

    @Bean
    public Binding proposalUpdatedBinding() {
        return BindingBuilder.bind(defenseUpdatedQueue()).to(defenseExchange());
    }

    @Bean
    public Binding proposalDeleteBinding() {
        return BindingBuilder.bind(defenseDeleteQueue()).to(defenseExchange());
    }

}

