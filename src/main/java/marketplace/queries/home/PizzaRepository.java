package marketplace.queries.home;

import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class PizzaRepository implements IPizzaRepository{

    @Override
    public List<Pizza> getAll() {
        throw new UnsupportedOperationException();
    }
}
