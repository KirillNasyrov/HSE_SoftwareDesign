package goodman_screbber;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import goodman_screbber.model.cook.ListOfCooks;
import goodman_screbber.model.dishCards.ListOfDishCards;
import goodman_screbber.model.menu.ListOfMenuDishes;
import goodman_screbber.model.visitorOrders.ListOfVisitorOrders;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class JsonParser {
    private final ObjectMapper objectMapper;

    public JsonParser() {
        objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
    }

    public ListOfVisitorOrders getListOfVisitorOrdersFromJson(Path path) throws IOException {
        ListOfVisitorOrders listOfVisitorOrders = objectMapper.readValue(path.toFile(), ListOfVisitorOrders.class);
        return listOfVisitorOrders;
    }

    public ListOfMenuDishes getListOfMenuDishesFromJson(Path path) throws IOException {
        ListOfMenuDishes listOfVisitorOrders = objectMapper.readValue(path.toFile(), ListOfMenuDishes.class);
        return listOfVisitorOrders;
    }

    public ListOfDishCards getListOfDishCardsFromJson(Path path) throws IOException {
        ListOfDishCards listOfVisitorOrders = objectMapper.readValue(path.toFile(), ListOfDishCards.class);
        return listOfVisitorOrders;
    }

    public ListOfCooks getListOfCooksFromJson(Path path) throws IOException {
        ListOfCooks listOfCooks = objectMapper.readValue(path.toFile(), ListOfCooks.class);
        return listOfCooks;
    }


}
