package domain.share.Infrastructure.Bus.Event;

import domain.marketplace.CQRS4.PizzasModule.Application.SendPizzaCreatedNotification.PizzaCreatedEvent;
import domain.marketplace.CQRS4.PizzasModule.Application.SendPizzaCreatedNotification.SendPizzaCreatedNotificationEventHandler;
import domain.share.Domain.Bus.Event.Event;
import domain.share.Domain.Bus.Event.EventBus;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.function.Consumer;

@Component
public class InMemoryEventBus implements EventBus {

    private final SendPizzaCreatedNotificationEventHandler sendPizzaCreatedNotificationEventHandler;

    public InMemoryEventBus(SendPizzaCreatedNotificationEventHandler sendPizzaCreatedNotificationEventHandler) {
        this.sendPizzaCreatedNotificationEventHandler = sendPizzaCreatedNotificationEventHandler;
    }

    @Override
    public <E extends Event> void dispatch(E event){
        HashMap<Object, Consumer<E>> subscriptions = generateMap();
        Consumer<E> function = subscriptions.get(event.getClass());
        function.accept(event);
    }

    private <E extends Event>
    HashMap<Object, Consumer<E>> generateMap(){
        return new HashMap<Object, Consumer<E>>() {{
            put(PizzaCreatedEvent.class,
                    (event) -> sendPizzaCreatedNotificationEventHandler.invoke((PizzaCreatedEvent) event));
        }};
    }
}
