package com.webApplication;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(
        scanBasePackages = {
                "com.webApplication.pages",
                "com.webApplication.controllers",
                "domain.marketplace",
                "domain.backoffice"
        }
)
public class CqrsApplication {

    public static void main(String[] args) {

        SpringApplication.run(CqrsApplication.class, args);
    }

}
