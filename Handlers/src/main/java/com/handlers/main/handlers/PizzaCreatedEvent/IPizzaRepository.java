package com.handlers.main.handlers.PizzaCreatedEvent;

public interface IPizzaRepository {
    void save(MongoTempPizza pizza);
}
