package com.webApplication.pages.backofficeHomeCQRS4;

public class AddPizzaRequestDto {
    private String img;
    private String name;
    private String price;

    public AddPizzaRequestDto() {
        this.img = "";
        this.name = "";
        this.price = "";
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
