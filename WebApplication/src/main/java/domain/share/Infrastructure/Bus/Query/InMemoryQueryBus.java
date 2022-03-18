package domain.share.Infrastructure.Bus.Query;

import domain.marketplace.CQRS4.PizzasModule.Application.GetAllPizzas.GetAllPizzasQuery;
import domain.marketplace.CQRS4.PizzasModule.Application.GetAllPizzas.GetAllPizzasQueryHandler;
import domain.share.Domain.Bus.Query.Query;
import domain.share.Domain.Bus.Query.QueryBus;
import domain.share.Domain.Bus.Query.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.function.Function;

@Component
public class InMemoryQueryBus implements QueryBus {

    private final GetAllPizzasQueryHandler getAllPizzasQueryHandler;

    @Autowired
    public InMemoryQueryBus(GetAllPizzasQueryHandler getAllPizzasQueryHandler) {
        this.getAllPizzasQueryHandler = getAllPizzasQueryHandler;
    }

    @Override
    public <R extends Response, Q extends Query> R ask(Q query){
        HashMap<Object, Function<Q, R>> subscriptions = generateMap();
        Function<Q, R> function = subscriptions.get(query.getClass());
        return function.apply(query);
    }

    private <Q extends Query, R extends Response>
    HashMap<Object, Function<Q, R>> generateMap(){
        return new HashMap<Object, Function<Q,R>>() {{
            put(GetAllPizzasQuery.class,(query) -> (R) getAllPizzasQueryHandler.invoke((GetAllPizzasQuery) query));
        }};
    }
}
