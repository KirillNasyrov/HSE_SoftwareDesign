package goodman_screbber;

import goodman_screbber.model.Restaurant;
import goodman_screbber.model.cook.ListOfCooks;
import goodman_screbber.model.dishCards.ListOfDishCards;
import goodman_screbber.model.menu.ListOfMenuDishes;
import goodman_screbber.model.visitorOrders.ListOfVisitorOrders;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        JsonParser jsonParser = new JsonParser();
        ListOfVisitorOrders listOfVisitorOrders;
        ListOfMenuDishes menuDishes;
        ListOfDishCards listOfDishCards;
        ListOfCooks listOfCooks;
        try {
            listOfVisitorOrders = jsonParser.getListOfVisitorOrdersFromJson();
        } catch (IOException ex) {
            System.out.println("Can't parse listOfVisitorOrders from Json");
            return;
        }

        try {
            menuDishes = jsonParser.getListOfMenuDishesFromJson();
        } catch (IOException ex) {
            System.out.println("Can't parse menuDishes from Json");
            return;
        }

        try {
            listOfDishCards = jsonParser.getListOfDishCardsFromJson();;
        } catch (IOException ex) {
            System.out.println("Can't parse listOfDishCards from Json");
            return;
        }

        try {
            listOfCooks = jsonParser.getListOfCooksFromJson();;
        } catch (IOException ex) {
            System.out.println("Can't parse listOfCooks from Json");
            return;
        }

        Restaurant restaurant = new Restaurant(listOfVisitorOrders, menuDishes, listOfDishCards, listOfCooks);
        restaurant.startWorking();
    }
}