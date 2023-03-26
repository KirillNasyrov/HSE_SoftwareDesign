package goodman_screbber.model.dishCards;

import java.util.ArrayList;
import java.util.List;

public class ListOfDishCards {
    private List<DishCard> dish_cards;

    public ListOfDishCards(List<DishCard> dish_cards) {
        this.dish_cards = new ArrayList<>(dish_cards);
    }

    public ListOfDishCards() {
    }

    public List<DishCard> getDish_cards() {
        return new ArrayList<>(dish_cards);
    }

    public void setDish_cards(List<DishCard> dish_cards) {
        this.dish_cards = new ArrayList<>(dish_cards);
    }
}
