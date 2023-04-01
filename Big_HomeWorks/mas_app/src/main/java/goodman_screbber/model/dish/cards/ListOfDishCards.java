package goodman_screbber.model.dish.cards;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class ListOfDishCards {
    @JsonProperty("dish_cards")
    private List<DishCard> dishCards;

    public ListOfDishCards(List<DishCard> dishCards) {
        this.dishCards = new ArrayList<>(dishCards);
    }

    public ListOfDishCards() {
    }

    public List<DishCard> getDishCards() {
        return new ArrayList<>(dishCards);
    }

    public void setDishCards(List<DishCard> dishCards) {
        this.dishCards = new ArrayList<>(dishCards);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ListOfDishCards that)) return false;

        return dishCards.equals(that.dishCards);
    }

    @Override
    public int hashCode() {
        return dishCards.hashCode();
    }
}
