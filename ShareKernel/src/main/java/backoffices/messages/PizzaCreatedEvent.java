package backoffices.messages;

import java.io.Serializable;

public class PizzaCreatedEvent implements Serializable {
    public String img;
    public String name;
    public String price;

    public String getImg() {
        return img;
    }

    public String getName() {
        return name;
    }

    public String getPrice() {
        return price;
    }
}
