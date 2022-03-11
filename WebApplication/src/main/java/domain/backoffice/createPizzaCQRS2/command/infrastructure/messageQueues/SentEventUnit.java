package infrastructure.MessageQueues;

public class SentEventUnit<T> implements Unit{

    private SentEventUnit() {
    }

    public static <T> SentEventUnit<T> CreateUnit(T arg) {

        return new SentEventUnit<T>();
    }
}
