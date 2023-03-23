package model;

public class MenuDishes {
    private int menu_dish_id;
    private int menu_dish_card;
    private int menu_dish_price;
    private boolean menu_dish_active;

    public MenuDishes(int menu_dish_id, int menu_dish_card, int menu_dish_price, boolean menu_dish_active) {
        this.menu_dish_id = menu_dish_id;
        this.menu_dish_card = menu_dish_card;
        this.menu_dish_price = menu_dish_price;
        this.menu_dish_active = menu_dish_active;
    }

    public MenuDishes() {
    }

    public int getMenu_dish_id() {
        return menu_dish_id;
    }

    public void setMenu_dish_id(int menu_dish_id) {
        this.menu_dish_id = menu_dish_id;
    }

    public int getMenu_dish_card() {
        return menu_dish_card;
    }

    public void setMenu_dish_card(int menu_dish_card) {
        this.menu_dish_card = menu_dish_card;
    }

    public int getMenu_dish_price() {
        return menu_dish_price;
    }

    public void setMenu_dish_price(int menu_dish_price) {
        this.menu_dish_price = menu_dish_price;
    }

    public boolean isMenu_dish_active() {
        return menu_dish_active;
    }

    public void setMenu_dish_active(boolean menu_dish_active) {
        this.menu_dish_active = menu_dish_active;
    }
}
