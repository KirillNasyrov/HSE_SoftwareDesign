package goodman_screbber.model.visitorOrders;

import goodman_screbber.model.Restaurant;

import java.util.Objects;

public class OrderDish {
    private Integer ord_dish_id;
    private Integer menu_dish;

    public OrderDish(Integer ordDishId, Integer menuDish) {
        ord_dish_id = ordDishId;
        menu_dish = menuDish;
    }

    public OrderDish() {
    }

    public Integer getOrd_dish_id() {
        return ord_dish_id;
    }

    public void setOrd_dish_id(Integer ord_dish_id) {
        this.ord_dish_id = ord_dish_id;
    }

    public Integer getMenu_dish() {
        return menu_dish;
    }

    public void setMenu_dish(Integer menu_dish) {
        this.menu_dish = menu_dish;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        OrderDish orderDish = (OrderDish) o;

        if (!Objects.equals(ord_dish_id, orderDish.ord_dish_id))
            return false;
        return Objects.equals(menu_dish, orderDish.menu_dish);
    }

    @Override
    public int hashCode() {
        int result = ord_dish_id != null ? ord_dish_id.hashCode() : 0;
        result = 31 * result + (menu_dish != null ? menu_dish.hashCode() : 0);
        return result;
    }
}
