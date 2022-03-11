package domain.backoffice.createPizzaCQRS3.command;

import java.io.Serializable;

public class createPizzaRequestEventSerializable implements Serializable {

    public String img;
    public String name;
    public float price;
}
