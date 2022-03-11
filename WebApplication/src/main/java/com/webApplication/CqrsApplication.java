package app.cqrs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;

@EnableAutoConfiguration
@SpringBootApplication(
        scanBasePackages = { "marketplace", "backoffice", "infrastructure"},
        exclude = {
            DataSourceAutoConfiguration.class,
            SecurityAutoConfiguration.class
        }
)

public class CqrsApplication {

    public static void main(String[] args) {

        SpringApplication.run(CqrsApplication.class, args);
    }

}
