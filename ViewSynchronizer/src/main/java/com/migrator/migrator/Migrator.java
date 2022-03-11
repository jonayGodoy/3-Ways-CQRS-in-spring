package com.migrator.migrator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class Migrator implements CommandLineRunner {

    private final JdbcTemplate jdbcTemplate;
    private final MongoTemplate mongoTemplate;

    @Autowired
    public Migrator(JdbcTemplate jdbcTemplate, MongoTemplate mongoTemplate) {
        this.jdbcTemplate = jdbcTemplate;
        this.mongoTemplate = mongoTemplate;
    }

    @Override
    public void run(String... args) throws Exception {
        var log = Logger.getLogger("Migration Process");
        log.info("Starting Migration from Sql to MongoDB");

        var sqlQuery = "SELECT * FROM pizza2";

        log.info("Deleting old Records");
        mongoTemplate.dropCollection("pizzas");

        var pizzas = jdbcTemplate.queryForList(sqlQuery).stream()
                .map((row) ->
                        new MongoTempPizza(
                                (String)row.get("img"),
                                (String)row.get("name"),
                                row.get("priceineuros").toString()
                        )).toList();
        mongoTemplate.insertAll(pizzas);
        log.info("All pizzas was copied correctly");
    }
}
