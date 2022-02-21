package backoffice.commands.createPizza;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreatePizzaCommand {

    private PizzaRepository repository;

    @Autowired
    public CreatePizzaCommand(PizzaRepository repository) {

        this.repository = repository;
    }

    public Pizza Execute(CreatePizzaRequest request){
        var pizza = new Pizza(
                request.getImg(),
                request.getName(),
                request.getPrice());
        return repository.CreatePizza(pizza);
    }

}
