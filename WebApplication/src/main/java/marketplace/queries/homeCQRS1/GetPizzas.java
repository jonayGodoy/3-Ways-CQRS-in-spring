package marketplace.queries.homeCQRS1;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component("GetPizzas1")
public class GetPizzas {

    private final PizzaRepository repository;

    @Autowired
    public GetPizzas(PizzaRepository repository) {

        this.repository = repository;
    }

    public List<Pizza> Execute(){
        return repository.getAll();
    }
}
