package domain.marketplace.CQRS4.PizzasModule.Domain;

public class Pizza {
    private final String img;
    private final String name;
    private final String price;

    public Pizza(String img, String name, float price) {
        this.img = img;
        this.name = name;
        this.price = price+"€";
    }

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
