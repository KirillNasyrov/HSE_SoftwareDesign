package model;

import java.util.ArrayList;
import java.util.List;

public class ListOfEquipmentType {
    private List<EquipmentType> equipment_type;

    public ListOfEquipmentType(List<EquipmentType> equipment_type) {
        this.equipment_type = new ArrayList<>(equipment_type);
    }

    public ListOfEquipmentType() {
    }

    public List<EquipmentType> getEquipment_type() {
        return new ArrayList<>(equipment_type);
    }

    public void setEquipment_type(List<EquipmentType> equipment_type) {
        this.equipment_type = new ArrayList<>(equipment_type);
    }
}
