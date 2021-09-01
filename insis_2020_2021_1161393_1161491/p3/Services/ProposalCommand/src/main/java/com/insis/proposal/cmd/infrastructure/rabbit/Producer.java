package com.insis.proposal.cmd.infrastructure.rabbit;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.stereotype.Component;

@Component
@EnableScheduling
public class Producer {

    private static final Logger logger = LoggerFactory.getLogger(Producer.class);

    @Autowired
    private RabbitTemplate rabbit;


    public void sendProposal(Object message) {
        rabbit.convertAndSend(RabbitConfig.proposalExchange, "", message);
    }

    public void updateProposal(Object message) {
        rabbit.convertAndSend(RabbitConfig.updateProposalExchange, "", message);
    }

    public void deleteProposal(Object message) {
        rabbit.convertAndSend(RabbitConfig.deleteProposalExchange, "", message);
    }

    public void sendFormalization(Object message) {
        rabbit.convertAndSend(RabbitConfig.createFormalizationExchange, "", message);
    }

    public void updateFormalization(Object message) {
        rabbit.convertAndSend(RabbitConfig.updateFormalizationExchange, "", message);
    }

    public void deleteFormalization(Object message) {
        rabbit.convertAndSend(RabbitConfig.deleteFormalizationExchange, "", message);
    }

    public void sendProponent(Object message) {
        rabbit.convertAndSend(RabbitConfig.proponentExchange, "", message);
    }
}
