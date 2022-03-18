package domain.marketplace.CQRS4.PizzasModule.Domain;

import com.webApplication.pages.marketplaceHomeCQRS3.queries.getPizzas.Pizza;

import java.util.List;

public interface PizzaRepository {

    List<Pizza> getAll();

}

