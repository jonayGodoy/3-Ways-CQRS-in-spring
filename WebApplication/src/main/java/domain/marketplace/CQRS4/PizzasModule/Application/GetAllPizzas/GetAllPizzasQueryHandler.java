package domain.marketplace.CQRS4.PizzasModule.Application.GetAllPizzas;

import domain.share.Domain.Bus.Query.QueryHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class GetAllPizzasQueryHandler implements QueryHandler<GetAllPizzasQuery, GetAllPizzasResponse> {

    private final AllPizzasSearcher searcher;

    @Autowired
    public GetAllPizzasQueryHandler(AllPizzasSearcher searcher) {

        this.searcher = searcher;
    }

    @Override
    public GetAllPizzasResponse invoke(GetAllPizzasQuery query){

        return searcher.searchAll();
    }
}
