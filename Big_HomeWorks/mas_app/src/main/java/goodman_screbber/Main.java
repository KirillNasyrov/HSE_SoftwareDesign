package goodman_screbber;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import model.Restaurant;
import model.agents.AgentOfOperation;
import model.dishCards.ListOfDishCards;
import model.menu.ListOfMenuDishes;
import model.visitorOrders.ListOfVisitorOrders;
import model.visitorOrders.OrderDish;
import model.visitorOrders.VisitorOrder;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException, InterruptedException {
        JsonParser jsonParser = new JsonParser();
        ListOfVisitorOrders listOfVisitorOrders = jsonParser.getListOfVisitorOrdersFromJson();
        ListOfMenuDishes menuDishes = jsonParser.getListOfMenuDishesFromJson();
        ListOfDishCards listOfDishCards = jsonParser.getListOfDishCardsFromJson();
        Restaurant restaurant = new Restaurant(listOfVisitorOrders, menuDishes, listOfDishCards);
        restaurant.startCooking();
    }
}