package domain.marketplace.CQRS4.PizzasModule.Domain;

public class Pizza {
    private final String img;
    private final String name;
    private final float price;

    public Pizza(String img, String name, float price) {
        this.img = img;
        this.name = name;
        this.price = price;
    }

    public static Pizza Create(String rawPrice, String name, String img) {
        var price = Float.parseFloat(rawPrice);
        return new Pizza(img, name, price);
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
