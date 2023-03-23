package model;

public class MenuItem {
    private Integer menu_dish_id;
    private Integer menu_dish_card;
    private Integer menu_dish_price;
    private Boolean menu_dish_active;

    public Integer getMenu_dish_id() {
        return menu_dish_id;
    }

    public void setMenu_dish_id(Integer menu_dish_id) {
        this.menu_dish_id = menu_dish_id;
    }

    public Integer getMenu_dish_card() {
        return menu_dish_card;
    }

    public void setMenu_dish_card(Integer menu_dish_card) {
        this.menu_dish_card = menu_dish_card;
    }

    public Integer getMenu_dish_price() {
        return menu_dish_price;
    }

    public void setMenu_dish_price(Integer menu_dish_price) {
        this.menu_dish_price = menu_dish_price;
    }

    public Boolean getMenu_dish_active() {
        return menu_dish_active;
    }

    public void setMenu_dish_active(Boolean menu_dish_active) {
        this.menu_dish_active = menu_dish_active;
    }
}
