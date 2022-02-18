package marketplace.queries.home;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PizzaRepository implements IPizzaRepository{

    private JdbcTemplate jdbcTemplate;

    @Autowired
    public PizzaRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Override
    public List<Pizza> getAll() {
        var sqlQuery = "SELECT * FROM pizza";
        return jdbcTemplate.queryForList(sqlQuery).stream()
                .map((row) ->
                        new Pizza(
                                (String)row.get("img"),
                                (String)row.get("name"),
                                ((Double)row.get("priceineuros")).floatValue()
                        )).toList();
    }
}
