package backoffice.commands.createPizzaCQRS3;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.function.Function;

@Component
public class CommandEventBus {

    private final CreatePizzaCommand createPizzaCommand;

    @Autowired
    public CommandEventBus(CreatePizzaCommand createPizzaCommand) {

        this.createPizzaCommand = createPizzaCommand;
    }

    public <T> T RaiseEvent(RequestEvent request){
        HashMap<Object, Function<RequestEvent, T>> subscriptions = generateMap();
        Function<RequestEvent, T> function = subscriptions.get(request.getClass());
        return function.apply(request);
    }

    private <T> HashMap<Object, Function<RequestEvent, T>> generateMap(){
        return new HashMap<Object, Function<RequestEvent, T>>() {{
            put(CreatePizzaRequestEvent.class,
                    (request) -> (T)createPizzaCommand.Execute(((CreatePizzaRequestEvent) request)));
        }};
    }
}
