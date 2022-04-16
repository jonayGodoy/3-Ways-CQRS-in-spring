package domain.marketplace.CQRS4.PizzasModule.Application.SendPizzaCreatedNotification;

import org.springframework.beans.factory.annotation.Autowired;

public class SendPizzaCreatedNotification {

    @Autowired
    private final PizzaCreatedNotificationSender sender;

    public SendPizzaCreatedNotification(PizzaCreatedNotificationSender sender) {
        this.sender = sender;
    }

    public void Execute(String pizzaName) {
        sender.send(new PizzaCreatedNotification(pizzaName));
    }
}
