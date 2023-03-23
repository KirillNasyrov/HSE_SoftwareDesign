package model;

public class Equipment {
    private Integer equip_type;
    private String equip_name;
    private boolean equip_active;

    public Equipment(Integer equip_type, String equipName, boolean equipActive) {
        this.equip_type = equip_type;
        equip_name = equipName;
        equip_active = equipActive;
    }

    public Equipment() {
    }

    public Integer getEquip_type() {
        return equip_type;
    }

    public void setEquip_type(Integer equip_type) {
        this.equip_type = equip_type;
    }

    public String getEquip_name() {
        return equip_name;
    }

    public void setEquip_name(String equip_name) {
        this.equip_name = equip_name;
    }

    public boolean isEquip_active() {
        return equip_active;
    }

    public void setEquip_active(boolean equip_active) {
        this.equip_active = equip_active;
    }
}
