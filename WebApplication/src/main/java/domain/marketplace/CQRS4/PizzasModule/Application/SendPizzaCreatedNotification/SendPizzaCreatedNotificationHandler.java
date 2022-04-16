package domain.marketplace.CQRS4.PizzasModule.Application.SendPizzaCreatedNotification;

import domain.share.Domain.Bus.Command.CommandHandler;
import org.springframework.beans.factory.annotation.Autowired;

public class SendPizzaCreatedNotificationHandler implements CommandHandler<PizzaCreatedNotificationCommand> {

    @Autowired
    private SendPizzaCreatedNotification sendPizzaCreatedNotification;

    public SendPizzaCreatedNotificationHandler(SendPizzaCreatedNotification sendPizzaCreatedNotification) {
        this.sendPizzaCreatedNotification = sendPizzaCreatedNotification;
    }

    @Override
    public void invoke(PizzaCreatedNotificationCommand command) {
        sendPizzaCreatedNotification.Execute(command.getPizzaName());
    }
}
