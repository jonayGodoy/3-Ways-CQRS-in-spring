package domain.marketplace.CQRS4.PizzasModule.Application.SendPizzaCreatedNotification;

import domain.share.Domain.Bus.Event.EventHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SendPizzaCreatedNotificationEventHandler implements EventHandler<PizzaCreatedEvent> {

    @Autowired
    private final SendPizzaCreatedNotification sendPizzaCreatedNotification;

    public SendPizzaCreatedNotificationEventHandler(SendPizzaCreatedNotification sendPizzaCreatedNotification) {
        this.sendPizzaCreatedNotification = sendPizzaCreatedNotification;
    }

    @Override
    public void invoke(PizzaCreatedEvent event) {
        sendPizzaCreatedNotification.Execute(event.getPizzaName());
    }
}
