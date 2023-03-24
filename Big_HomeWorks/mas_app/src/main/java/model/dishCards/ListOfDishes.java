package model.dishCards;

import model.dishCards.DishCards;

import java.util.ArrayList;
import java.util.List;

public class ListOfDishes {
    private List<DishCards> dish_cards;

    public ListOfDishes(List<DishCards> dish_cards) {
        this.dish_cards = new ArrayList<>(dish_cards);
    }

    public ListOfDishes() {
    }

    public List<DishCards> getDish_cards() {
        return new ArrayList<>(dish_cards);
    }

    public void setDish_cards(List<DishCards> dish_cards) {
        this.dish_cards = new ArrayList<>(dish_cards);
    }
}
