package domain.marketplace.CQRS4.PizzasModule.Infrastructure.Persistence;

import domain.marketplace.CQRS4.PizzasModule.Domain.Pizza;
import domain.marketplace.CQRS4.PizzasModule.Domain.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository("MarketplacePizzaRepository4")
public class MysqlPizzaRepository implements PizzaRepository {

    private final JdbcTemplate jdbcTemplate;

    @Autowired
    public MysqlPizzaRepository(JdbcTemplate jdbcTemplate) {

        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Pizza> getAll() {
        var sqlQuery = "SELECT * FROM pizza4";
        return jdbcTemplate.queryForList(sqlQuery).stream()
                .map((row) ->
                        new Pizza(
                                (String)row.get("img"),
                                (String)row.get("name"),
                                ((Double)row.get("priceineuros")).floatValue()
                        )).toList();
    }

    @Override
    public void createPizza(Pizza pizza) {
        var sql = "INSERT INTO pizza4 (name, img, priceInEuros) VALUES (?, ?, ?)";
        try {
            jdbcTemplate.update(
                    sql,
                    pizza.getName(),
                    pizza.getImg(),
                    pizza.getPrice());
        }catch (DataAccessException ignored){

        }
    }
}
