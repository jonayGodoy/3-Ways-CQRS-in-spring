package marketplace.queries.home;

import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class PizzaRepository implements IPizzaRepository{

    @Override
    public List<Pizza> getAll() {
        return Arrays.asList(
                new Pizza("bbq.png","bbq", 3.99f),
                new Pizza("4Cheeses.png","4Cheeses", 4.99f),
                new Pizza("carbonara.png","carbonara", 2.99f),
                new Pizza("Cesar.png","Cesar", 5.99f),
                new Pizza("hawaiana.PNG","hawaiana", -3.99f),
                new Pizza("nachos.png","nachos", -30.99f)
        );
    }
}
