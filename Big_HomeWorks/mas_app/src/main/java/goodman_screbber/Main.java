package goodman_screbber;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Menu;
import model.MenuItem;

public class Main {
    public static void main(String[] args) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper();
        String jsonString = "";

        Menu menuItem = objectMapper.readValue(jsonString, Menu.class);
        for (MenuItem menuDish : menuItem.menu_dishes) {
            System.out.println(menuDish.getMenu_dish_card());
        }
    }
}