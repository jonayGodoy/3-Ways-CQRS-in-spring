package backoffice.commands.createPizzaCQRS3;

import java.time.LocalDateTime;

public interface RequestEvent {
    LocalDateTime getTimespan();
}
