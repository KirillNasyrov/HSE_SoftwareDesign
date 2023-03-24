package model.menu;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    public List<MenuDish> menu_dishes;

    public Menu(List<MenuDish> menu_dishes) {
        this.menu_dishes = new ArrayList<>(menu_dishes);
    }

    public Menu() {
    }

    public List<MenuDish> getMenu_dishes() {
        return new ArrayList<>(menu_dishes);
    }

    public void setMenu_dishes(List<MenuDish> menu_dishes) {
        this.menu_dishes = new ArrayList<>(menu_dishes);
    }
}
