package goodman_screbber.model.menu;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListOfMenuDishes {

    @JsonProperty("menu_dishes")
    public List<MenuDish> menuDishes;

    public ListOfMenuDishes(List<MenuDish> menuDishes) {
        this.menuDishes = new ArrayList<>(menuDishes);
    }

    public ListOfMenuDishes() {
    }

    public List<MenuDish> getMenuDishes() {
        return new ArrayList<>(menuDishes);
    }

    public void setMenuDishes(List<MenuDish> menuDishes) {
        this.menuDishes = new ArrayList<>(menuDishes);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListOfMenuDishes that = (ListOfMenuDishes) o;

        return Objects.equals(menuDishes, that.menuDishes);
    }

    @Override
    public int hashCode() {
        return menuDishes != null ? menuDishes.hashCode() : 0;
    }
}
