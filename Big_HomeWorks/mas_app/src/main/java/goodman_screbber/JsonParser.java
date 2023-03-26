package goodman_screbber;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import model.dishCards.ListOfDishCards;
import model.menu.ListOfMenuDishes;
import model.visitorOrders.ListOfVisitorOrders;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class JsonParser {
    private final ObjectMapper objectMapper;

    public JsonParser() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
    }

    public ListOfVisitorOrders getListOfVisitorOrdersFromJson() throws IOException {
        Path path = FileSystems.getDefault().getPath("src", "main","java", "input", "visitors_orders.json");
        ListOfVisitorOrders listOfVisitorOrders = objectMapper.readValue(path.toFile(), ListOfVisitorOrders.class);
        return listOfVisitorOrders;
    }

    public ListOfMenuDishes getListOfMenuDishesFromJson() throws IOException {
        Path path = FileSystems.getDefault().getPath("src", "main","java", "input", "menu_dishes.json");
        ListOfMenuDishes listOfVisitorOrders = objectMapper.readValue(path.toFile(), ListOfMenuDishes.class);
        return listOfVisitorOrders;
    }

    public ListOfDishCards getListOfDishCardsFromJson() throws IOException {
        Path path = FileSystems.getDefault().getPath("src", "main","java", "input", "dish_cards.json");
        ListOfDishCards listOfVisitorOrders = objectMapper.readValue(path.toFile(), ListOfDishCards.class);
        return listOfVisitorOrders;
    }


}
