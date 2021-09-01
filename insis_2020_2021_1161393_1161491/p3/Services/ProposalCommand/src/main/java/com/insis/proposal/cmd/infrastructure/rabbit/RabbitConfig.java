package com.insis.proposal.cmd.infrastructure.rabbit;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfig {

    static final String proposalExchange = "insis.proposal.command.exchange";

    static final String updateProposalExchange = "insis.proposal.update.exchange";

    static final String deleteProposalExchange = "insis.proposal.delete.exchange";

    static final String proponentExchange = "insis.rabbitmq.three.proposals.proponent.exchange";

    static final String proposalCreatedQueue = "insis.rabbitmq.proposal.created.queue";

    static final String proposalUpdatedQueue = "insis.rabbitmq.proposal.updated.queue";

    static final String proposalDeleteQueue = "insis.rabbitmq.proposal.delete.queue";

    static final String createFormalizationExchange = "insis.formalization.create.exchange";

    static final String updateFormalizationExchange = "insis.formalization.update.exchange";

    static final String deleteFormalizationExchange = "insis.formalization.delete.exchange";

    static final String formalizationCreatedQueue = "insis.rabbitmq.formalization.created.queue";

    static final String formalizationUpdatedQueue = "insis.rabbitmq.formalization.updated.queue";

    static final String formalizationDeleteQueue = "insis.rabbitmq.formalization.delete.queue";

    //falta o nome da queue de desativar o proponent

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
    FanoutExchange proponentExchange() {
        return new FanoutExchange(proponentExchange);
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
