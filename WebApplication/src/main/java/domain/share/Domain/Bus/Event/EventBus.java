package domain.share.Domain.Bus.Event;

import domain.share.Domain.Bus.Command.Command;

public interface EventBus {
    <E extends Event> void dispatch(E event);
}
