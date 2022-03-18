package domain.marketplace.CQRS4.PizzasModule.Infrastructure.Persistence;

import com.webApplication.pages.marketplaceHomeCQRS3.queries.getPizzas.Pizza;
import domain.marketplace.CQRS4.PizzasModule.Domain.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
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
}
