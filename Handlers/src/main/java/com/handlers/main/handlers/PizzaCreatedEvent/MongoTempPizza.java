package com.handlers.main.handlers.PizzaCreatedEvent;

import org.springframework.data.mongodb.core.mapping.Document;

@Document("pizzas")
public class MongoTempPizza {

    public String img;
    public String name;
    public String priceineuros;

    public MongoTempPizza(String img, String name, String priceineuros) {

        this.img = img;
        this.name = name;
        this.priceineuros = priceineuros;
    }
}
