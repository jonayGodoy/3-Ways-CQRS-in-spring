package domain.backoffice.createPizzaCQRS2.command;

public interface IPizzaRepository {

    Pizza CreatePizza(Pizza pizza);
}
