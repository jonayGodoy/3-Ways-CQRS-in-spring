package domain.backoffice.createPizzaCQRS3.infrastructure.eventBus;

import domain.backoffice.createPizzaCQRS3.command.CreatePizzaCommand;
import domain.backoffice.createPizzaCQRS3.command.RequestEvent;
import domain.backoffice.createPizzaCQRS3.command.CreatePizzaRequestEvent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.function.Function;

@Component
public class CommandEventBus {

    private final CommandRequestEventRepository repository;
    private final CreatePizzaCommand createPizzaCommand;

    @Autowired
    public CommandEventBus(
            CommandRequestEventRepository repository,
            CreatePizzaCommand createPizzaCommand) {
        this.repository = repository;
        this.createPizzaCommand = createPizzaCommand;
    }

    public <T> T raiseEvent(RequestEvent request){
        HashMap<Object, Function<RequestEvent, T>> subscriptions = generateMap();
        Function<RequestEvent, T> function = subscriptions.get(request.getClass());
        var result = function.apply(request);
        repository.save(request);
        return result;
    }

    private <T> HashMap<Object, Function<RequestEvent, T>> generateMap(){
        return new HashMap<Object, Function<RequestEvent, T>>() {{
            put(CreatePizzaRequestEvent.class,
                    (request) -> (T)createPizzaCommand.Execute(((CreatePizzaRequestEvent) request)));
        }};
    }
}
