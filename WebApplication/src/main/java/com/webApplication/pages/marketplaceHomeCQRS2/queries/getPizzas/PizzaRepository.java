package com.webApplication.pages.marketplaceHomeCQRS2.queries.getPizzas;

import org.bson.Document;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository("MarketplacePizzaRepository2")
public class PizzaRepository implements IPizzaRepository {

    private final MongoTemplate mongoTemplate;

    @Autowired
    public PizzaRepository(MongoTemplate mongoTemplate) {

        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public List<Pizza> getAll() {
        final List<Document> results = new ArrayList<>();
        var a = mongoTemplate
                .getCollection("pizzas")
                .find()
                .into(results);

        return results.stream().map((row) ->
                        new Pizza((String)row.get("img"),
                                (String)row.get("name"),
                                (Float.parseFloat((String)row.get("priceineuros")))
                        )).toList();
    }
}
