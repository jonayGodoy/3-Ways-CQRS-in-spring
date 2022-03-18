package domain.marketplace.CQRS4.PizzasModule.Application.GetAllPizzas;

import domain.share.Domain.Bus.Query.Response;

import java.util.List;

public class GetAllPizzasResponse implements Response {

    public List<PizzaDto> pizzas;

    public GetAllPizzasResponse(List<PizzaDto> pizzas) {

        this.pizzas = pizzas;
    }

    public List<PizzaDto> getPizzas() {
        return pizzas;
    }

    public void setPizzas(List<PizzaDto> pizzas) {
        this.pizzas = pizzas;
    }
}
