package domain.backoffice.createPizzaCQRS3.createPizzaCQRS3;

import java.io.Serializable;
import java.time.LocalDateTime;

public interface RequestEvent {
    LocalDateTime getTimespan();

    <T extends Serializable> T getSerializable();
}
