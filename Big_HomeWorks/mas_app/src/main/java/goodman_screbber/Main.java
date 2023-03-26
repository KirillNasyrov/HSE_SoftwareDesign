package goodman_screbber;

import goodman_screbber.model.Restaurant;
import goodman_screbber.model.dishCards.ListOfDishCards;
import goodman_screbber.model.menu.ListOfMenuDishes;
import goodman_screbber.model.visitorOrders.ListOfVisitorOrders;

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