package domain.backoffice.createPizzaCQRS3.command;

public interface IPizzaRepository {

    Pizza CreatePizza(Pizza pizza);
}
