package com.handlers.handlers;

import java.util.concurrent.TimeUnit;

import backoffices.messages.PizzaCreatedEvent;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.MessageBuilder;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class Runner implements CommandLineRunner {

    private final RabbitTemplate rabbitTemplate;
    private final Receiver receiver;

    public Runner(Receiver receiver, RabbitTemplate rabbitTemplate) {
        this.receiver = receiver;
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        System.out.println("Sending message...");
        var message = new PizzaCreatedEvent();
        message.name = "PIZZA1";
        message.price = "0";
        message.img = "olives.png";



        rabbitTemplate.convertAndSend(
                HandlersApplication.topicExchangeName,
                "createdPizza",
                message);
        receiver.getLatch().await(10000, TimeUnit.MILLISECONDS);
    }

}
