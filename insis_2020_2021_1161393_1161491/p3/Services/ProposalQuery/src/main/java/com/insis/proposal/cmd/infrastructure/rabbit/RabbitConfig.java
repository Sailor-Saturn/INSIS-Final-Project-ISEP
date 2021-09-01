package com.insis.proposal.cmd.infrastructure.rabbit;

import org.springframework.amqp.core.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;


@Configuration
public class RabbitConfig {

    @Value("${insis.rabbitmq.proposal.exchange}")
    private String proposalExchange;

    @Value("${insis.rabbitmq.proposal.created.queue}")
    private String proposalCreatedQueue;

    static final String updateProposalExchange = "insis.proposal.update.exchange";

    static final String deleteProposalExchange = "insis.proposal.delete.exchange";

    static final String createFormalizationExchange = "insis.formalization.create.exchange";

    static final String updateFormalizationExchange = "insis.formalization.update.exchange";

    static final String deleteFormalizationExchange = "insis.formalization.delete.exchange";

    @Value("${insis.rabbitmq.proposal.updated.queue}")
    private String proposalUpdatedQueue;

    @Value("${insis.rabbitmq.proposal.delete.queue}")
    private String proposalDeleteQueue;

    @Value("${insis.rabbitmq.formalization.created.queue}")
    private String formalizationCreatedQueue;

    @Value("${insis.rabbitmq.formalization.updated.queue}")
    private String formalizationUpdatedQueue;

    @Value("${insis.rabbitmq.formalization.delete.queue}")
    private String formalizationDeleteQueue;

    @Bean
    FanoutExchange proposalExchange() {
        return new FanoutExchange(proposalExchange);
    }

    @Bean
    FanoutExchange updateProposalExchange() {
        return new FanoutExchange(updateProposalExchange);
    }

    @Bean
    FanoutExchange deleteProposalExchange() {
        return new FanoutExchange(deleteProposalExchange);
    }

    @Bean
    FanoutExchange createFormalizationExchange() {
        return new FanoutExchange(createFormalizationExchange);
    }

    @Bean
    FanoutExchange updateFormalizationExchange() {
        return new FanoutExchange(updateFormalizationExchange);
    }

    @Bean
    FanoutExchange deleteFormalizationExchange() {
        return new FanoutExchange(deleteFormalizationExchange);
    }

    @Bean
    public Queue proposalCreatedQueue() {
        return new Queue(proposalCreatedQueue);
    }

    @Bean
    public Queue proposalUpdatedQueue() {
        return new Queue(proposalUpdatedQueue);
    }

    @Bean
    public Queue proposalDeleteQueue() {
        return new Queue(proposalDeleteQueue);
    }

    @Bean
    public Queue formalizationCreatedQueue() {
        return new Queue(formalizationCreatedQueue);
    }

    @Bean
    public Queue formalizationUpdatedQueue() {
        return new Queue(formalizationUpdatedQueue);
    }

    @Bean
    public Queue formalizationDeleteQueue() {
        return new Queue(formalizationDeleteQueue);
    }

    @Bean
    public Binding proposalCreateBinding() {
        return BindingBuilder.bind(proposalCreatedQueue()).to(proposalExchange());
    }

    @Bean
    public Binding proposalUpdatedBinding() {
        return BindingBuilder.bind(proposalUpdatedQueue()).to(updateProposalExchange());
    }

    @Bean
    public Binding proposalDeleteBinding() {
        return BindingBuilder.bind(proposalDeleteQueue()).to(deleteProposalExchange());
    }

    @Bean
    public Binding formalizationCreatedBinding() {
        return BindingBuilder.bind(formalizationCreatedQueue()).to(createFormalizationExchange());
    }

    @Bean
    public Binding formalizationUpdatedBinding() {
        return BindingBuilder.bind(formalizationUpdatedQueue()).to(updateFormalizationExchange());
    }

    @Bean
    public Binding formalizationDeleteBinding() {
        return BindingBuilder.bind(formalizationDeleteQueue()).to(deleteFormalizationExchange());
    }

}

