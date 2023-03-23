package model;

import java.util.ArrayList;
import java.util.List;

public class ListOfCooks {
    private List<Cook> cookers;

    public ListOfCooks(List<Cook> cookers) {
        this.cookers = new ArrayList<>(cookers);
    }

    public List<Cook> getCookers() {
        return new ArrayList<>(cookers);
    }

    public void setCookers(List<Cook> cookers) {
        this.cookers = cookers;
    }
}
