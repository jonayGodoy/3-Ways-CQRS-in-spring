package domain.marketplace.CQRS4.PizzasModule.Application.SendPizzaCreatedNotification;

import domain.share.Domain.Bus.Command.Command;

public class PizzaCreatedNotificationCommand implements Command {

    private final String pizzaName;

    public PizzaCreatedNotificationCommand(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public String getPizzaName() {
        return pizzaName;
    }

}
