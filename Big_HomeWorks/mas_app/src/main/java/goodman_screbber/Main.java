package goodman_screbber;

import goodman_screbber.model.Restaurant;
import goodman_screbber.model.cook.ListOfCooks;
import goodman_screbber.model.dish.cards.ListOfDishCards;
import goodman_screbber.model.menu.ListOfMenuDishes;
import goodman_screbber.model.visitor.orders.ListOfVisitorOrders;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        JsonParser jsonParser = new JsonParser();
        ConsoleWorker consoleWorker = new ConsoleWorker();

        ListOfVisitorOrders listOfVisitorOrders;
        ListOfMenuDishes menuDishes;
        ListOfDishCards listOfDishCards;
        ListOfCooks listOfCooks;
        try {
            Path path1 = FileSystems.getDefault().getPath(consoleWorker.getStringPathOfOrders());
            listOfVisitorOrders = jsonParser.getListOfVisitorOrdersFromJson(path1);
        } catch (IOException ex) {
            System.out.println("Can't parse listOfVisitorOrders from Json");
            return;
        }

        try {
            Path path2 = FileSystems.getDefault().getPath(consoleWorker.getStringPathOfMenuDishes());
            menuDishes = jsonParser.getListOfMenuDishesFromJson(path2);
        } catch (IOException ex) {
            System.out.println("Can't parse menuDishes from Json");
            return;
        }

        try {
            Path path3 = FileSystems.getDefault().getPath(consoleWorker.getStringPathOfDishCards());
            listOfDishCards = jsonParser.getListOfDishCardsFromJson(path3);
        } catch (IOException ex) {
            System.out.println("Can't parse listOfDishCards from Json");
            return;
        }

        try {
            Path path4 = FileSystems.getDefault().getPath(consoleWorker.getStringPathOfCooks());
            listOfCooks = jsonParser.getListOfCooksFromJson(path4);
        } catch (IOException ex) {
            System.out.println("Can't parse listOfCooks from Json");
            return;
        }

        Restaurant restaurant = new Restaurant(listOfVisitorOrders, menuDishes, listOfDishCards, listOfCooks);
        try {
            restaurant.startWorking();
        } catch (InterruptedException e) {
            System.out.println("InterruptedException while startWorking");
        }
        try {
            restaurant.stopWorking();
        } catch (InterruptedException e) {
            System.out.println("InterruptedException while stopWorking");
        }
    }
}