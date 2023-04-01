package goodman_screbber.model.menu;

import com.fasterxml.jackson.annotation.JsonProperty;

public class MenuDish {

    @JsonProperty("menu_dish_id")
    private int menuDishId;

    @JsonProperty("menu_dish_card")
    private int menuDishCard;

    @JsonProperty("menu_dish_price")
    private int menuDishPrice;

    @JsonProperty("menu_dish_active")
    private boolean menuDishActive;

    public MenuDish(int menuDishId, int menuDishCard, int menuDishPrice, boolean menuDishActive) {
        this.menuDishId = menuDishId;
        this.menuDishCard = menuDishCard;
        this.menuDishPrice = menuDishPrice;
        this.menuDishActive = menuDishActive;
    }

    public MenuDish() {
    }

    public int getMenuDishId() {
        return menuDishId;
    }

    public void setMenuDishId(int menuDishId) {
        this.menuDishId = menuDishId;
    }

    public int getMenuDishCard() {
        return menuDishCard;
    }

    public void setMenuDishCard(int menuDishCard) {
        this.menuDishCard = menuDishCard;
    }

    public int getMenuDishPrice() {
        return menuDishPrice;
    }

    public void setMenuDishPrice(int menuDishPrice) {
        this.menuDishPrice = menuDishPrice;
    }

    public boolean isMenuDishActive() {
        return menuDishActive;
    }

    public void setMenuDishActive(boolean menuDishActive) {
        this.menuDishActive = menuDishActive;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        MenuDish menuDish = (MenuDish) o;

        if (menuDishId != menuDish.menuDishId) return false;
        if (menuDishCard != menuDish.menuDishCard) return false;
        if (menuDishPrice != menuDish.menuDishPrice) return false;
        return menuDishActive == menuDish.menuDishActive;
    }

    @Override
    public int hashCode() {
        int result = menuDishId;
        result = 31 * result + menuDishCard;
        result = 31 * result + menuDishPrice;
        result = 31 * result + (menuDishActive ? 1 : 0);
        return result;
    }
}
