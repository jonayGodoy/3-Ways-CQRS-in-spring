package domain.marketplace.CQRS4.PizzasModule.Application.CreatePizza;

import domain.share.Domain.Bus.Command.Command;

public class CreatePizzaCommand implements Command {
    private String img;
    private String name;
    private String price;

    public CreatePizzaCommand(String img, String name, String price) {
        this.img = img;
        this.name = name;
        this.price = price;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }
}
