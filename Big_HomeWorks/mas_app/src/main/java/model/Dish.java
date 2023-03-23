package model;

import java.util.ArrayList;
import java.util.List;

public class Dish {
    private List<DishCards> dish_cards;

    public Dish(List<DishCards> dish_cards) {
        this.dish_cards = new ArrayList<>(dish_cards);
    }

    public Dish() {
    }

    public List<DishCards> getDish_cards() {
        return new ArrayList<>(dish_cards);
    }

    public void setDish_cards(List<DishCards> dish_cards) {
        this.dish_cards = new ArrayList<>(dish_cards);
    }
}
