package app.cqrs.pages.marketplaceHomeCQRS1.queries.getPizzas;

import java.util.List;

public interface IPizzaRepository {

    List<Pizza> getAll();

}

