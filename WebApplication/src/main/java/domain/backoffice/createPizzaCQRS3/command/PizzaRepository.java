package domain.backoffice.createPizzaCQRS3.command;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("BackofficePizzaRepository3")
public class PizzaRepository implements IPizzaRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PizzaRepository(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    public Pizza CreatePizza(Pizza pizza) {
        var sql = "INSERT INTO pizza3 (name, img, priceInEuros) VALUES (?, ?, ?)";
        try {
            jdbcTemplate.update(
                    sql,
                    pizza.getName(),
                    pizza.getImg(),
                    pizza.getPrice());
        }catch (DataAccessException ex){
            return null;
        }
        return pizza;
    }
}
