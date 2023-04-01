package goodman_screbber.model.cook;

import java.util.ArrayList;
import java.util.List;

public class ListOfCooks {
    private List<Cook> cookers;

    public ListOfCooks(List<Cook> cookers) {
        this.cookers = new ArrayList<>(cookers);
    }

    public ListOfCooks() {
    }

    public List<Cook> getCookers() {
        return new ArrayList<>(cookers);
    }

    public void setCookers(List<Cook> cookers) {
        this.cookers = new ArrayList<>(cookers);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListOfCooks that)) return false;

        return cookers.equals(that.cookers);
    }

    @Override
    public int hashCode() {
        return cookers.hashCode();
    }
}
