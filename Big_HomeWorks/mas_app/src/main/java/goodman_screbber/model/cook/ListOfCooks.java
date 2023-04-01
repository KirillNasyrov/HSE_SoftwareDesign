package goodman_screbber.model.cook;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class ListOfCooks {
    @JsonProperty("cookers")
    private List<Cook> cooks;

    public ListOfCooks(List<Cook> cooks) {
        this.cooks = new ArrayList<>(cooks);
    }

    public ListOfCooks() {
    }

    public List<Cook> getCooks() {
        return new ArrayList<>(cooks);
    }

    public void setCooks(List<Cook> cooks) {
        this.cooks = new ArrayList<>(cooks);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListOfCooks that)) return false;

        return cooks.equals(that.cooks);
    }

    @Override
    public int hashCode() {
        return cooks.hashCode();
    }
}
