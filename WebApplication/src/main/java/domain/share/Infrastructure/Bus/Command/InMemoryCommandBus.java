package domain.share.Infrastructure.Bus.Command;


import domain.marketplace.CQRS4.PizzasModule.Application.CreatePizza.CreatePizzaCommand;
import domain.marketplace.CQRS4.PizzasModule.Application.CreatePizza.CreatePizzaCommandHandler;
import domain.share.Domain.Bus.Command.Command;
import domain.share.Domain.Bus.Command.CommandBus;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.function.Consumer;

@Primary
@Component
public class InMemoryCommandBus implements CommandBus {

    private final CreatePizzaCommandHandler createPizzaCommandHandler;

    public InMemoryCommandBus(CreatePizzaCommandHandler createPizzaCommandHandler) {
        this.createPizzaCommandHandler = createPizzaCommandHandler;
    }

    @Override
    public <C extends Command> void dispatch(C command){
        HashMap<Object, Consumer<C>> subscriptions = generateMap();
        Consumer<C> function = subscriptions.get(command.getClass());
        function.accept(command);
    }

    private <C extends Command>
    HashMap<Object, Consumer<C>> generateMap(){
        return new HashMap<Object, Consumer<C>>() {{
            put(CreatePizzaCommand.class,
                    (command) -> createPizzaCommandHandler.invoke((CreatePizzaCommand) command));
        }};
    }
}
