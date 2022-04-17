package com.webApplication;

import domain.backoffice.createPizzaCQRS2.command.infrastructure.messageQueues.IMessageQueue;
import domain.backoffice.createPizzaCQRS2.command.infrastructure.messageQueues.MessageQueue;
import domain.marketplace.CQRS4.PizzasModule.Application.CreatePizza.CreatePizza;
import domain.marketplace.CQRS4.PizzasModule.Application.CreatePizza.CreatePizzaCommandHandler;
import domain.share.Infrastructure.Bus.Event.InMemoryAsyncEventBus;
import domain.share.Infrastructure.Bus.Event.InMemoryEventBus;
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

    @Bean
    public InMemoryAsyncEventBus InMemoryAsyncEventBus(InMemoryEventBus bus){
        return new InMemoryAsyncEventBus(bus);
    }
}
