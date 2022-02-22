package infrastructure.MessageQueues;

import org.springframework.stereotype.Component;

@Component
public interface IMessageQueue {

    public <T> SentEventUnit<T> sendA(T message);

}

