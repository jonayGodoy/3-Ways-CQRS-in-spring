package backoffice.commands.createPizza;

public class Pizza {
    private final String img;
    private final String name;
    private final float price;

    public Pizza(String img, String name, float price) {
        this.img = img;
        this.name = name;
        this.price = price;
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
