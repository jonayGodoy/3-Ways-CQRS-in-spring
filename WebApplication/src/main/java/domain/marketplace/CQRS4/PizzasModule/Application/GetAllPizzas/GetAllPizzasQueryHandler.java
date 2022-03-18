package domain.marketplace.CQRS4.PizzasModule.Application.GetAllPizzas;

import domain.share.Domain.Bus.Query.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class GetAllPizzasQueryHandler implements QueryHandler {

    private final AllPizzasSearcher searcher;

    @Autowired
    public GetAllPizzasQueryHandler(AllPizzasSearcher searcher) {
        this.searcher = searcher;
    }

    public GetAllPizzasResponse invoke(GetAllPizzasQuery query){
        return searcher.searchAll();
    }

}
