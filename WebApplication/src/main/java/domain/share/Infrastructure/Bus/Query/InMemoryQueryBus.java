package domain.share.Infrastructure.Bus.Query;

import domain.share.Domain.Bus.Query.Query;
import domain.share.Domain.Bus.Query.QueryBus;
import domain.share.Domain.Bus.Query.Response;

public class InMemoryQueryBus implements QueryBus {

    @Override
    public Response ask(Query query) {
        throw new UnsupportedOperationException();

    }
}
