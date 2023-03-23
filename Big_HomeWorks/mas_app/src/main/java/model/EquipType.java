package model;

public class EquipType {
    private String equip_type_name;
    private Integer equip_type_id;
    public EquipType(int equipTypeId, String equipTypeName) {
        equip_type_id = equipTypeId;
        equip_type_name = equipTypeName;
    }
    public int getEquip_type_id() {
        return equip_type_id;
    }
    public void setEquip_type_id(int equip_type_id) {
        this.equip_type_id = equip_type_id;
    }
    public String getEquip_type_name() {
        return equip_type_name;
    }
    public void setEquip_type_name(String equip_type_name) {
        this.equip_type_name = equip_type_name;
    }
}
