package backoffice.commands.createPizza;

import backoffices.messages.PizzaCreatedEvent;
import infrastructure.MessageQueues.IMessageQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CreatePizzaCommand {

    private IMessageQueue queue;
    private PizzaRepository repository;

    @Autowired
    public CreatePizzaCommand(IMessageQueue queue, PizzaRepository repository) {
        this.queue = queue;
        this.repository = repository;
    }

    public Pizza Execute(CreatePizzaRequest request){
            var pizza = new Pizza(
                    request.getImg(),
                    request.getName(),
                    request.getPrice());
             queue.sendA(createPizzaCreatedEvent(pizza));
        return repository.CreatePizza(pizza);
    }

    public PizzaCreatedEvent createPizzaCreatedEvent(Pizza pizza) {
        var event = new PizzaCreatedEvent();
        event.name = pizza.getName();
        event.price = Float.toString(pizza.getPrice());
        event.img = pizza.getImg();
        return event;
    }
}

