package domain.backoffice.createPizzaCQRS2.command.infrastructure.messageQueues;

public class SentEventUnit<T> implements Unit{

    private SentEventUnit() {
    }

    public static <T> SentEventUnit<T> CreateUnit(T arg) {

        return new SentEventUnit<T>();
    }
}
