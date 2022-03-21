package domain.marketplace.CQRS4.PizzasModule.Application.CreatePizza;

import domain.share.Domain.Bus.Command.CommandHandler;
import org.springframework.stereotype.Service;

@Service
public class CreatePizzaCommandHandler implements CommandHandler<CreatePizzaCommand> {

    private final CreatePizza createPizza;

    public CreatePizzaCommandHandler(CreatePizza createPizza) {
        this.createPizza = createPizza;
    }

    @Override
    public void invoke(CreatePizzaCommand command) {
        createPizza.Execute(command);
    }
}
