package com.handlers.main.handlers.PizzaCreatedEvent;

import backoffices.messages.PizzaCreatedEvent;
import org.springframework.beans.factory.annotation.Autowired;

public class PizzaCreatedEventHandler {

    IPizzaRepository repository;

    public PizzaCreatedEventHandler(IPizzaRepository repository) {
        this.repository = repository;
    }

    public void handle(PizzaCreatedEvent event) {

        var pizza = new MongoTempPizza(
                event.getImg(),
                event.getName(),
                event.getPrice());
        repository.save(pizza);
        
    }
}


