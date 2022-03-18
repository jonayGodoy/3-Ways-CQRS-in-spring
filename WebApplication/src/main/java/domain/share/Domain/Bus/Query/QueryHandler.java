package domain.share.Domain.Bus.Query;

public interface QueryHandler<Q extends Query, R extends Response> {
     R invoke(Q query);
}
