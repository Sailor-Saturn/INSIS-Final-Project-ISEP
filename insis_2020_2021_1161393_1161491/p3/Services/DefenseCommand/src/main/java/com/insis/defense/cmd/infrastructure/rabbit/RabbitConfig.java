package com.insis.defense.cmd.infrastructure.rabbit;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


@Configuration
public class RabbitConfig {
    static final String defenseExchange = "insis.defense.command.exchange";

    static final String updateDefenseExchange = "insis.defense.update.exchange";

    static final String deleteDefenseExchange = "insis.defense.delete.exchange";

    @Bean
    FanoutExchange defenseExchange() {
        return new FanoutExchange(defenseExchange);
    }

    @Bean
    FanoutExchange updateDefenseExchange() {
        return new FanoutExchange(updateDefenseExchange);
    }

    @Bean
    FanoutExchange deleteDefenseExchange() {
        return new FanoutExchange(deleteDefenseExchange);
    }
}
