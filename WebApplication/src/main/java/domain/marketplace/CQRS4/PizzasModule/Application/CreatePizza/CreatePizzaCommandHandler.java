package domain.marketplace.CQRS4.PizzasModule.Application.CreatePizza;

import domain.marketplace.CQRS4.PizzasModule.Application.SendPizzaCreatedNotification.PizzaCreatedEvent;
import domain.share.Domain.Bus.Command.CommandHandler;
import domain.share.Domain.Bus.Event.EventBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreatePizzaCommandHandler implements CommandHandler<CreatePizzaCommand> {

    private final CreatePizza createPizza;
    private final EventBus bus;

    @Autowired
    public CreatePizzaCommandHandler(CreatePizza createPizza, EventBus bus) {
        this.createPizza = createPizza;
        this.bus = bus;
    }

    //todo: do that method transactional
    @Override
    public void invoke(CreatePizzaCommand command) {
        createPizza.Execute(command.getName(), command.getPrice(), command.getImg());
        bus.dispatch(new PizzaCreatedEvent(command.getName()));
    }
}
