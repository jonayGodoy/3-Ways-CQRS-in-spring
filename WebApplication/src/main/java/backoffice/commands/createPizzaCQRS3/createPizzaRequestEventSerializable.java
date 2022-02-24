package backoffice.commands.createPizzaCQRS3;

import java.io.Serializable;

public class createPizzaRequestEventSerializable implements Serializable {

    public String img;
    public String name;
    public float price;
}
