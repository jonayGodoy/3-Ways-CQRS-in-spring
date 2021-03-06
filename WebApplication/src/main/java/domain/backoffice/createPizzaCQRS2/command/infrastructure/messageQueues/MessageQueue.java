package domain.backoffice.createPizzaCQRS2.command.infrastructure.messageQueues;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class MessageQueue implements IMessageQueue {

    private final RabbitTemplate rabbitTemplate;

    @Autowired
    public MessageQueue(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    @Override
    public <T> SentEventUnit<T> sendA(T message) {
        rabbitTemplate.convertAndSend(
                message.getClass().getName(),
                message);
        return SentEventUnit.CreateUnit(message);
    }
}
