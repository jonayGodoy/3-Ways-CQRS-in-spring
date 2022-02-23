package backoffice.commands.createPizzaCQRS1;

public class CreatePizzaRequest {
    private final String img;
    private final String name;
    private final float price;

    public CreatePizzaRequest(String img, String name, float price) {
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

    private static float formatPrice(String price) {
        return Float.parseFloat(price);
    }

    public static CreatePizzaRequest create(AddPizzaRequestDto dto) {
        return new CreatePizzaRequest(
                dto.getImg(),
                dto.getName(),
                formatPrice(dto.getPrice()));
    }
}
