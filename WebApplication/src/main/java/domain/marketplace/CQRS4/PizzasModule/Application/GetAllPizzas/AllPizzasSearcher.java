package domain.marketplace.CQRS4.PizzasModule.Application.GetAllPizzas;

import domain.marketplace.CQRS4.PizzasModule.Domain.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AllPizzasSearcher {

    private final PizzaRepository repository;

    @Autowired
    public AllPizzasSearcher(PizzaRepository repository) {
        this.repository = repository;
    }

    public GetAllPizzasResponse searchAll() {

        return new GetAllPizzasResponse(repository.getAll().stream().map(
                (pizza) -> new PizzaDto(pizza.getImg(), pizza.getName(), pizza.getPrice())
        ).toList());
    }
}
