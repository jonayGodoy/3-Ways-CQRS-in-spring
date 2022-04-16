package domain.marketplace.CQRS4.PizzasModule.Application.SendPizzaCreatedNotification;

public class PizzaCreatedNotification {

    private final String pizzaName;

    public PizzaCreatedNotification(String pizzaName) {
        this.pizzaName = pizzaName;
    }

    public String getPizzaName() {
        return pizzaName;
    }
}
