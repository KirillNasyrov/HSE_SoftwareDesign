package model;

import java.util.List;

public class DishCards {
    private Integer card_id;
    private String dish_name;
    private String card_descr;
    private Double card_time;
    private Integer equip_type;
    private List<DIshCardsOperations> operations;

    public Integer getCard_id() {
        return card_id;
    }

    public void setCard_id(Integer card_id) {
        this.card_id = card_id;
    }

    public String getDish_name() {
        return dish_name;
    }

    public void setDish_name(String dish_name) {
        this.dish_name = dish_name;
    }

    public String getCard_descr() {
        return card_descr;
    }

    public void setCard_descr(String card_descr) {
        this.card_descr = card_descr;
    }

    public Double getCard_time() {
        return card_time;
    }

    public void setCard_time(Double card_time) {
        this.card_time = card_time;
    }

    public Integer getEquip_type() {
        return equip_type;
    }

    public void setEquip_type(Integer equip_type) {
        this.equip_type = equip_type;
    }

    public List<DIshCardsOperations> getOperations() {
        return operations;
    }

    public void setOperations(List<DIshCardsOperations> operations) {
        this.operations = operations;
    }
}
