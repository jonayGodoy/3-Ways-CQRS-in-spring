package com.handlers.main.handlers.PizzaCreatedEvent;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class PizzaRepository implements IPizzaRepository {

    @Autowired
    private MongoTemplate mongoTemplate;

    public PizzaRepository(MongoTemplate mongoTemplate) {
        this.mongoTemplate = mongoTemplate;
    }

    public void save(MongoTempPizza pizza) {
        mongoTemplate.save(pizza);
    }
}
