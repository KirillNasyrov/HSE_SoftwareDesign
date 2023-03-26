package goodman_screbber.model.menu;

import java.util.ArrayList;
import java.util.List;

public class ListOfMenuDishes {
    public List<MenuDish> menu_dishes;

    public ListOfMenuDishes(List<MenuDish> menu_dishes) {
        this.menu_dishes = new ArrayList<>(menu_dishes);
    }

    public ListOfMenuDishes() {
    }

    public List<MenuDish> getMenu_dishes() {
        return new ArrayList<>(menu_dishes);
    }

    public void setMenu_dishes(List<MenuDish> menu_dishes) {
        this.menu_dishes = new ArrayList<>(menu_dishes);
    }
}
