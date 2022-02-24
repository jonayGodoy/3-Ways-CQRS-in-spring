package backoffice.commands.createPizzaCQRS3.EventBus;

import backoffice.commands.createPizzaCQRS3.CreatePizzaCommand;
import backoffice.commands.createPizzaCQRS3.CreatePizzaRequestEvent;
import backoffice.commands.createPizzaCQRS3.RequestEvent;
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

    public <T> T RaiseEvent(RequestEvent request){
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
