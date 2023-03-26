package goodman_screbber.model.equipment;

import java.util.ArrayList;
import java.util.List;

public class ListOfKitchenEquipment {
    private List<Equipment> equipment;

    public ListOfKitchenEquipment(List<Equipment> equipment) {
        this.equipment = new ArrayList<>(equipment);
    }

    public ListOfKitchenEquipment() {
    }

    public List<Equipment> getEquipment() {
        return new ArrayList<>(equipment);
    }

    public void setEquipment(List<Equipment> equipment) {
        this.equipment = new ArrayList<>(equipment);
    }
}
