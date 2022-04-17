package domain.share.Domain.Bus.Event;

public interface EventHandler<E extends Event> {
    void invoke(E event);
}
