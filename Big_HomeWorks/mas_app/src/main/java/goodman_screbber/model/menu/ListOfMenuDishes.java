package goodman_screbber.model.menu;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListOfMenuDishes that = (ListOfMenuDishes) o;

        return Objects.equals(menu_dishes, that.menu_dishes);
    }

    @Override
    public int hashCode() {
        return menu_dishes != null ? menu_dishes.hashCode() : 0;
    }
}
