package backoffice.commands.createPizzaCQRS3;

import java.time.LocalDateTime;;

public class CreatePizzaRequestEvent implements RequestEvent {
    private final String img;
    private final String name;
    private final float price;
    private LocalDateTime timespan;

    public CreatePizzaRequestEvent(String img, String name, float price) {
        timespan = LocalDateTime.now();
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

    public static CreatePizzaRequestEvent create(AddPizzaRequestDto dto) {
        return new CreatePizzaRequestEvent(
                dto.getImg(),
                dto.getName(),
                formatPrice(dto.getPrice()));
    }

    @Override
    public LocalDateTime getTimespan() {
        return timespan;
    }
}
