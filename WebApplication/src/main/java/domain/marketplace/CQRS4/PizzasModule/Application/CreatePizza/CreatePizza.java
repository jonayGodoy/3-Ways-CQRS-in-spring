package domain.marketplace.CQRS4.PizzasModule.Application.CreatePizza;

import domain.marketplace.CQRS4.PizzasModule.Domain.Pizza;
import domain.marketplace.CQRS4.PizzasModule.Domain.PizzaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreatePizza {

    private final PizzaRepository repository;

    @Autowired
    public CreatePizza(PizzaRepository repository) {
        this.repository = repository;
    }

    public void Execute(String name, String price, String img){
        var pizza = Pizza.Create(price, name, img);
        repository.createPizza(pizza);
    }
}

