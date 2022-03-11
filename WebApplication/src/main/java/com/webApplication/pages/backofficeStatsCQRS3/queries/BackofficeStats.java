package com.webApplication.pages.backofficeStatsCQRS3.queries;

import java.util.List;

public class BackofficeStats {

    private int quantityImgDtoWhenCreatedPizza;

    private List<Stat> stats;

    public BackofficeStats(int quantityImgDto, List<Stat> stats) {
        this.quantityImgDtoWhenCreatedPizza = quantityImgDto;
        this.stats = stats;
    }

    public int getQuantityImgDtoWhenCreatedPizza() {
        return quantityImgDtoWhenCreatedPizza;
    }

    public void setQuantityImgDtoWhenCreatedPizza(int quantityImgDtoWhenCreatedPizza) {
        this.quantityImgDtoWhenCreatedPizza = quantityImgDtoWhenCreatedPizza;
    }

    public List<Stat> getStats() {
        return stats;
    }

    public void setStats(List<Stat> stats) {
        this.stats = stats;
    }
}

