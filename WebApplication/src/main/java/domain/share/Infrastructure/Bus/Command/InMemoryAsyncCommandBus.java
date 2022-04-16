package domain.share.Infrastructure.Bus.Command;


import domain.share.Domain.Bus.Command.Command;
import domain.share.Domain.Bus.Command.CommandBus;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

@Component
public class InMemoryAsyncCommandBus implements CommandBus {

    @Autowired
    private final InMemoryCommandBus commandBus;

    private final ExecutorService executorService = Executors.newSingleThreadExecutor();

    public InMemoryAsyncCommandBus(InMemoryCommandBus commandBus) {
        this.commandBus = commandBus;
    }

    @Override
    public <C extends Command> void dispatch(C command){
        Runnable runnable = () -> {commandBus.dispatch(command);};
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
