package domain.marketplace.CQRS4.PizzasModule.Application.GetAllPizzas;

public class PizzaDto {
    public String img;
    public String name;
    public String price;

    public PizzaDto(String img, String name, float price) {
        this.img = img;
        this.name = name;
        this.price = price+"€";
    }
}