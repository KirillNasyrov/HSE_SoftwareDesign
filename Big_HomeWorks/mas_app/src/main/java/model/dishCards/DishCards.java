package model.dishCards;

import java.util.ArrayList;
import java.util.List;

public class DishCards {
    private Integer card_id;
    private String dish_name;
    private String card_descr;
    private Double card_time;
    private Integer equip_type;
    private List<DishCardsOperations> operations;

    public DishCards(Integer card_id, String dish_name, String card_descr, Double card_time, Integer equip_type, List<DishCardsOperations> operations) {
        this.card_id = card_id;
        this.dish_name = dish_name;
        this.card_descr = card_descr;
        this.card_time = card_time;
        this.equip_type = equip_type;
        this.operations = new ArrayList<>(operations);
    }

    public DishCards() {
    }

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

    public List<DishCardsOperations> getOperations() {
        return new ArrayList<>(operations);
    }

    public void setOperations(List<DishCardsOperations> operations) {
        this.operations = new ArrayList<>(operations);
    }
}