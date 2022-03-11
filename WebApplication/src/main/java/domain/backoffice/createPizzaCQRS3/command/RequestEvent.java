package domain.backoffice.createPizzaCQRS3.command;

import java.io.Serializable;
import java.time.LocalDateTime;

public interface RequestEvent {
    LocalDateTime getTimespan();

    <T extends Serializable> T getSerializable();
}
