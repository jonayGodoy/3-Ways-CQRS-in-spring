package com.migrator.migrator;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.concurrent.TimeUnit;
import java.util.logging.Logger;

@Component
public class Migrator implements CommandLineRunner {





    @Override
    public void run(String... args) throws Exception {
        var log = Logger.getLogger("Migration Process");
        log.info("Starting Migration from Sql to MongoDB");
    }

}
