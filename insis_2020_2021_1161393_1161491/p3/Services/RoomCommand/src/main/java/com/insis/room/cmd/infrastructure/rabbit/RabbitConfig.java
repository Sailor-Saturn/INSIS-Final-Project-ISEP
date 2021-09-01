package com.insis.room.cmd.infrastructure.rabbit;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfig {

    static final String createRoomExchange = "insis.room.create.exchange";

    static final String updateRoomExchange = "insis.room.update.exchange";

    static final String deleteRoomExchange = "insis.room.delete.exchange";

    static final String roomCreatedQueue = "insis.rabbitmq.room.created.queue";

    static final String roomUpdatedQueue = "insis.rabbitmq.room.updated.queue";

    static final String roomDeleteQueue = "insis.rabbitmq.room.delete.queue";

    @Bean
    FanoutExchange createRoomExchange() {
        return new FanoutExchange(createRoomExchange);
    }

    @Bean
    FanoutExchange updateRoomExchange() {
        return new FanoutExchange(updateRoomExchange);
    }

    @Bean
    FanoutExchange deleteRoomExchange() {
        return new FanoutExchange(deleteRoomExchange);
    }

    @Bean
    public Queue roomCreatedQueue() {
        return new Queue(roomCreatedQueue);
    }

    @Bean
    public Queue roomUpdatedQueue() {
        return new Queue(roomUpdatedQueue);
    }

    @Bean
    public Queue roomDeleteQueue() {
        return new Queue(roomDeleteQueue);
    }

    @Bean
    public Binding roomCreateBinding() {
        return BindingBuilder.bind(roomCreatedQueue()).to(createRoomExchange());
    }

    @Bean
    public Binding roomUpdatedBinding() {
        return BindingBuilder.bind(roomUpdatedQueue()).to(updateRoomExchange());
    }

    @Bean
    public Binding roomDeleteBinding() {
        return BindingBuilder.bind(roomDeleteQueue()).to(deleteRoomExchange());
    }

}
