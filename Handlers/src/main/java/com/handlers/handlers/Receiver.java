package com.handlers.handlers;

import backoffices.messages.PizzaCreatedEvent;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.amqp.core.Message;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.concurrent.CountDownLatch;

@Component
public class Receiver {

    private CountDownLatch latch = new CountDownLatch(1);

    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
        latch.countDown();
    }

    public void receiveMessage(PizzaCreatedEvent message) {

        System.out.println("Received <" + message.name + ">");
        latch.countDown();
    }

    public CountDownLatch getLatch() {
        return latch;
    }

}
