package domain.marketplace.CQRS4.PizzasModule.Domain;

import java.util.List;

public interface PizzaRepository {

    List<Pizza> getAll();

    void createPizza(Pizza pizza);
}

