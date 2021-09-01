package com.insis.room.cmd.infrastructure.rabbit;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    @Autowired
    private RabbitTemplate rabbit;

    public void sendRoom(Object message) {
        rabbit.convertAndSend(RabbitConfig.createRoomExchange, "", message);
    }

    public void updateRoom(Object message) {
        rabbit.convertAndSend(RabbitConfig.updateRoomExchange, "", message);
    }

    public void deleteRoom(Object message) {
        rabbit.convertAndSend(RabbitConfig.deleteRoomExchange, "", message);
    }

}
