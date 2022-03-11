package app.cqrs.pages.marketplaceHomeCQRS2.queries.getPizzas;

import java.util.List;

public interface IPizzaRepository {

    List<Pizza> getAll();

}

