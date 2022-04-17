package domain.marketplace.CQRS4.PizzasModule.Application.SendPizzaCreatedNotification;

import domain.share.Domain.Bus.Event.Event;

public class PizzaCreatedEvent implements Event {

    private final String pizzaName;

    public PizzaCreatedEvent(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public String getPizzaName() {
        return pizzaName;
    }

}
