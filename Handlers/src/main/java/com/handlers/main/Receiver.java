package com.handlers.main;

import backoffices.messages.PizzaCreatedEvent;
import com.handlers.main.handlers.PizzaCreatedEvent.PizzaCreatedEventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.CountDownLatch;

@Component
public class Receiver {

    private final PizzaCreatedEventHandler pizzaCreatedEventHandler;
    private CountDownLatch latch = new CountDownLatch(1);

    @Autowired
    public Receiver(PizzaCreatedEventHandler pizzaCreatedEventHandler) {
        this.pizzaCreatedEventHandler = pizzaCreatedEventHandler;
    }

    public void receiveMessage(String message) {
        System.out.println("Received <" + message + ">");
        latch.countDown();
    }

    public void receiveMessage(PizzaCreatedEvent message) {
        pizzaCreatedEventHandler.handle(message);
    }

    public CountDownLatch getLatch() {
        return latch;
    }

}
