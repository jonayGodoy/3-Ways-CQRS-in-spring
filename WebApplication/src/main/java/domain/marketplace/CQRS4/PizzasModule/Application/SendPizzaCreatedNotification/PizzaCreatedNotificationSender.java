package domain.marketplace.CQRS4.PizzasModule.Application.SendPizzaCreatedNotification;

public interface PizzaCreatedNotificationSender {

    void send(PizzaCreatedNotification notification);

}
