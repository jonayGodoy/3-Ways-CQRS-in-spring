package domain.share.Infrastructure.Bus.Event;


import domain.share.Domain.Bus.Event.Event;
import domain.share.Domain.Bus.Event.EventBus;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Primary
@Component
public class InMemoryAsyncEventBus implements EventBus {

    private final ExecutorService executorService = Executors.newSingleThreadExecutor();
    private final InMemoryEventBus eventBus;

    public InMemoryAsyncEventBus(InMemoryEventBus eventBus) {
        this.eventBus = eventBus;
    }

    @Override
    public <E extends Event> void dispatch(E event){
        Runnable runnable = () -> {eventBus.dispatch(event);};
        Future<Void> future = executorService.submit(new Dispatcher(runnable));
    }
}

class Dispatcher implements Callable<Void> {

    private final Runnable runnable;

    Dispatcher(Runnable runnable) {
        this.runnable = runnable;
    }

    @Override
    public Void call() throws Exception {
        runnable.run();
        return null;
    }
}
