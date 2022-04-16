package domain.marketplace.CQRS4.PizzasModule.Infrastructure.Persistence;

import domain.marketplace.CQRS4.PizzasModule.Application.SendPizzaCreatedNotification.PizzaCreatedNotification;
import domain.marketplace.CQRS4.PizzasModule.Application.SendPizzaCreatedNotification.PizzaCreatedNotificationSender;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class FakeEmailPizzaCreatedNotificationSender implements PizzaCreatedNotificationSender {

    private final JdbcTemplate jdbcTemplate;


    @Autowired
    public FakeEmailPizzaCreatedNotificationSender(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public void send(PizzaCreatedNotification notification) {
        var sql = "INSERT INTO pizzaCreatedNotification (pizzaName, notificationMessage) VALUES (?, ?)";
        try {
            jdbcTemplate.update(
                    sql,
                    notification.getPizzaName(),
                    "Fue creada una pizza con el nombre "+notification.getPizzaName());
        }catch (DataAccessException ignored){

        }
    }
}
