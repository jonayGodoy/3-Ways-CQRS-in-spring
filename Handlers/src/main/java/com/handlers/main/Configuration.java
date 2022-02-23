package com.handlers.main;

import com.handlers.main.handlers.PizzaCreatedEvent.PizzaCreatedEventHandler;
import com.handlers.main.handlers.PizzaCreatedEvent.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;

@org.springframework.context.annotation.Configuration
public class Configuration {

    @Autowired
    @Bean
    PizzaCreatedEventHandler PizzaCreatedEventHandler(MongoTemplate mongoTemplate){
        return new PizzaCreatedEventHandler(
                new PizzaRepository(mongoTemplate));
    }
}
