package com.insis.defense.cmd.infrastructure.rabbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Producer {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);

    @Autowired
    private RabbitTemplate rabbit;

    public void sendDefense(Object message) {
        rabbit.convertAndSend(RabbitConfig.defenseExchange, "", message);
    }

    public void updateDefense(Object message) {
        rabbit.convertAndSend(RabbitConfig.updateDefenseExchange, "", message);
    }

    public void deleteDefense(Object message) {
        rabbit.convertAndSend(RabbitConfig.deleteDefenseExchange, "", message);
    }
}
