package domain.backoffice.createPizzaCQRS2.command.infrastructure.messageQueues;

import org.springframework.stereotype.Component;

@Component
public interface IMessageQueue {

    public <T> SentEventUnit<T> sendA(T message);

}

