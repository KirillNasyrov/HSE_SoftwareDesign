package model;

import java.util.List;

public class Dish {
    private List<DishCards> dish_cards;

    public List<DishCards> getDish_cards() {
        return dish_cards;
    }

    public void setDish_cards(List<DishCards> dish_cards) {
        this.dish_cards = dish_cards;
    }
}
