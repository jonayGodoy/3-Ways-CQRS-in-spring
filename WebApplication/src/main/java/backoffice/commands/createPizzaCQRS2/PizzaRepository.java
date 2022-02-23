package backoffice.commands.createPizzaCQRS2;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

@Repository("BackofficePizzaRepositor2y")
public class PizzaRepository implements IPizzaRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public PizzaRepository(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    public Pizza CreatePizza(Pizza pizza) {
        var sql = "INSERT INTO pizza2 (name, img, priceInEuros) VALUES (?, ?, ?)";
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
