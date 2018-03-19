package pooa20171.iff.br.webserviceappfipe.business;

import java.io.Serializable;

public abstract class SimpleBean implements Serializable {
    protected String id;
    protected String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return name;
    }
}
