package com.webApplication.controllers.createPizzaControllerCQRS2;

import domain.backoffice.createPizzaCQRS2.command.Pizza;

public class PizzaResponseDto {
    private final String img;
    private final String name;
    private final float price;

    public PizzaResponseDto(Pizza pizza) {
        this.img = pizza.getImg();
        this.name = pizza.getName();
        this.price = pizza.getPrice();
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
