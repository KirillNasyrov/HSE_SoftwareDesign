package model.visitorOrders;

import model.dishCards.ListOfDishes;
import model.menu.ListOfMenuDishes;

import java.util.NoSuchElementException;

public class OrderDish {
    private Integer ord_dish_id;
    private Integer menu_dish;

    public OrderDish(Integer ordDishId, Integer menuDish) {
        ord_dish_id = ordDishId;
        menu_dish = menuDish;
    }

    public OrderDish() {
    }

    public Double getCookingTime(ListOfDishes listOfDishes) {
        for (var dish : listOfDishes.getDish_cards()) {
            if (dish.getCard_id().equals(ord_dish_id)) {
                return dish.getCard_time();
            }
        }
        throw new NoSuchElementException();
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
}
