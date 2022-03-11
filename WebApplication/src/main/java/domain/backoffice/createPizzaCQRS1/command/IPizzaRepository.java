package domain.backoffice.createPizzaCQRS1.command;

public interface IPizzaRepository {

    Pizza CreatePizza(Pizza pizza);
}
