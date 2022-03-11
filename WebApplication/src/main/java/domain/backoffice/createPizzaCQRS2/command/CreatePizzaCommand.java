package domain.backoffice.createPizzaCQRS2.command;

import backoffices.messages.PizzaCreatedEvent;
import domain.backoffice.createPizzaCQRS2.command.infrastructure.messageQueues.IMessageQueue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component("CreatePizzaCommand2")
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
            var result = repository.CreatePizza(pizza);
              queue.sendA(createPizzaCreatedEvent(pizza));
        return result;
    }

    public PizzaCreatedEvent createPizzaCreatedEvent(Pizza pizza) {
        var event = new PizzaCreatedEvent();
        event.name = pizza.getName();
        event.price = Float.toString(pizza.getPrice());
        event.img = pizza.getImg();
        return event;
    }
}

