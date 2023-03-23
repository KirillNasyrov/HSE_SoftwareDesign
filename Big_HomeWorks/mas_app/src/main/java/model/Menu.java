package model;

import java.util.ArrayList;
import java.util.List;

public class Menu {
    public List<MenuDishes> menu_dishes;

    public Menu(List<MenuDishes> menu_dishes) {
        this.menu_dishes = new ArrayList<>(menu_dishes);
    }

    public Menu() {
    }

    public List<MenuDishes> getMenu_dishes() {
        return new ArrayList<>(menu_dishes);
    }

    public void setMenu_dishes(List<MenuDishes> menu_dishes) {
        this.menu_dishes = new ArrayList<>(menu_dishes);
    }
}
