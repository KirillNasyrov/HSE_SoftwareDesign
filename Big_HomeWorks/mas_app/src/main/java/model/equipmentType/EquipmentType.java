package model.equipmentType;

public class EquipmentType {
    private Integer equip_type_id;
    private String equip_type_name;

    public EquipmentType(Integer equip_type_id, String equip_type_name) {
        this.equip_type_id = equip_type_id;
        this.equip_type_name = equip_type_name;
    }

    public EquipmentType() {
    }

    public Integer getEquip_type_id() {
        return equip_type_id;
    }

    public void setEquip_type_id(Integer equip_type_id) {
        this.equip_type_id = equip_type_id;
    }

    public String getEquip_type_name() {
        return equip_type_name;
    }

    public void setEquip_type_name(String equip_type_name) {
        this.equip_type_name = equip_type_name;
    }
}
