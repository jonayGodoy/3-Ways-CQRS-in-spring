package domain.share.Domain.Bus.Query;

public interface QueryBus {

    <R extends Response, Q extends Query> R ask(Q query);

}
