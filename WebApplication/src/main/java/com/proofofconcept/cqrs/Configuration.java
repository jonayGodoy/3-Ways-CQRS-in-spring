package com.proofofconcept.cqrs;

import infrastructure.MessageQueues.IMessageQueue;
import infrastructure.MessageQueues.MessageQueue;
import org.springframework.amqp.rabbit.connection.CachingConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.context.annotation.Bean;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Bean
    public CachingConnectionFactory connectionFactory() {
        CachingConnectionFactory connectionFactory = new CachingConnectionFactory();
        var env = System.getenv();
        connectionFactory.setHost(env.get("spring.rabbitmq.host"));
        var port = Integer.valueOf(env.get("spring.rabbitmq.port"));
        connectionFactory.setPort(port);
        connectionFactory.setUsername(env.get("spring.rabbitmq.username"));
        connectionFactory.setPassword(env.get("spring.rabbitmq.password"));
        return connectionFactory;
    }

    @Bean
    public RabbitTemplate rabbitTemplate() {
        return new RabbitTemplate(connectionFactory());
    }

    @Bean
    public IMessageQueue IMessageQueue(RabbitTemplate template){
        return new MessageQueue(template);
    }
}
