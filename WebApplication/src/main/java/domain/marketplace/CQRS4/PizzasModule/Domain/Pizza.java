package domain.marketplace.CQRS4.PizzasModule.Domain;

import domain.marketplace.CQRS4.PizzasModule.Application.CreatePizza.CreatePizzaCommand;

public class Pizza {
    private final String img;
    private final String name;
    private final float price;

    public Pizza(String img, String name, float price) {
        this.img = img;
        this.name = name;
        this.price = price;
    }

    public static Pizza Create(CreatePizzaCommand command) {
        var price = Float.parseFloat(command.getPrice());
        return new Pizza(command.getImg(), command.getName(), price);
    }

    public String getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public float getPrice() {
        return price;
    }
}
