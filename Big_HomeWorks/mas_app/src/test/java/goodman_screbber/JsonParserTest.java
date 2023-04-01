package goodman_screbber;

import goodman_screbber.model.cook.Cook;
import goodman_screbber.model.cook.ListOfCooks;
import goodman_screbber.model.dish.cards.DishCard;
import goodman_screbber.model.dish.cards.DishCardsOperations;
import goodman_screbber.model.dish.cards.DishCardsOperationsProducts;
import goodman_screbber.model.dish.cards.ListOfDishCards;
import goodman_screbber.model.menu.ListOfMenuDishes;
import goodman_screbber.model.menu.MenuDish;
import goodman_screbber.model.visitor.orders.ListOfVisitorOrders;
import goodman_screbber.model.visitor.orders.OrderDish;
import goodman_screbber.model.visitor.orders.VisitorOrder;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

class JsonParserTest {

    @Test
    void getListOfVisitorOrdersFromJsonTestCorrectJson() throws IOException {
        OrderDish originalOrderDish1 = new OrderDish(625, 28);
        OrderDish originalOrderDish2 = new OrderDish(626, 28);
        OrderDish originalOrderDish3 = new OrderDish(627, 28);


        VisitorOrder originalVisitorOrder1 = new VisitorOrder();
        originalVisitorOrder1.setVis_name("Visitor123");
        originalVisitorOrder1.setVis_ord_started(LocalDateTime.parse("2023-02-28T10:12:15"));
        originalVisitorOrder1.setVis_ord_ended(null);
        originalVisitorOrder1.setVis_ord_total(118);
        originalVisitorOrder1.setVis_ord_dishes(List.of(originalOrderDish1, originalOrderDish2));


        VisitorOrder originalVisitorOrder2 = new VisitorOrder();
        originalVisitorOrder2.setVis_name("Visitor124");
        originalVisitorOrder2.setVis_ord_started(LocalDateTime.parse("2023-02-28T10:12:05"));
        originalVisitorOrder2.setVis_ord_ended(null);
        originalVisitorOrder2.setVis_ord_total(59);
        originalVisitorOrder2.setVis_ord_dishes(List.of(originalOrderDish3));


        ListOfVisitorOrders originalListOfVisitorOrders = new ListOfVisitorOrders();
        originalListOfVisitorOrders.setVisitors_orders(List.of(originalVisitorOrder1, originalVisitorOrder2));

        ListOfVisitorOrders testListOfVisitorOrders;
        JsonParser jsonParser = new JsonParser();
        Path path = FileSystems.getDefault().getPath("src/test/resources/inputForTest/visitorOrdersJsonsForTest/visitors_orders.json");
        testListOfVisitorOrders = jsonParser.getListOfVisitorOrdersFromJson(path);
        Assertions.assertEquals(testListOfVisitorOrders, originalListOfVisitorOrders);
    }

    @Test
    void getListOfVisitorOrdersFromJsonTestNotCorrectJson() throws IOException {
        OrderDish originalOrderDish1 = new OrderDish(625, 28);
        OrderDish originalOrderDish2 = new OrderDish(626, 28);
        OrderDish originalOrderDish3 = new OrderDish(627, 28);


        VisitorOrder originalVisitorOrder1 = new VisitorOrder();
        originalVisitorOrder1.setVis_name("Visitor123");
        originalVisitorOrder1.setVis_ord_started(LocalDateTime.parse("2023-02-28T10:12:15"));
        originalVisitorOrder1.setVis_ord_ended(null);
        originalVisitorOrder1.setVis_ord_total(118);
        originalVisitorOrder1.setVis_ord_dishes(List.of(originalOrderDish1, originalOrderDish2));


        VisitorOrder originalVisitorOrder2 = new VisitorOrder();
        originalVisitorOrder2.setVis_name("Visitor128");
        originalVisitorOrder2.setVis_ord_started(LocalDateTime.parse("2023-02-28T10:12:05"));
        originalVisitorOrder2.setVis_ord_ended(null);
        originalVisitorOrder2.setVis_ord_total(53);
        originalVisitorOrder2.setVis_ord_dishes(List.of(originalOrderDish3));


        ListOfVisitorOrders originalListOfVisitorOrders = new ListOfVisitorOrders();
        originalListOfVisitorOrders.setVisitors_orders(List.of(originalVisitorOrder1, originalVisitorOrder2));

        ListOfVisitorOrders testListOfVisitorOrders;
        JsonParser jsonParser = new JsonParser();
        Path path = FileSystems.getDefault().getPath("src/test/resources/inputForTest/visitorOrdersJsonsForTest/visitors_orders.json");
        testListOfVisitorOrders = jsonParser.getListOfVisitorOrdersFromJson(path);
        Assertions.assertNotEquals(testListOfVisitorOrders, originalListOfVisitorOrders);
    }

    @Test
    void getListOfMenuDishesFromJsonTestCorrectJson() throws IOException {
        MenuDish originalMenuDish1 = new MenuDish();
        originalMenuDish1.setMenuDishId(28);
        originalMenuDish1.setMenuDishCard(518);
        originalMenuDish1.setMenuDishPrice(59);
        originalMenuDish1.setMenuDishActive(true);


        MenuDish originalMenuDish2 = new MenuDish();
        originalMenuDish2.setMenuDishId(34);
        originalMenuDish2.setMenuDishCard(145);
        originalMenuDish2.setMenuDishPrice(100);
        originalMenuDish2.setMenuDishActive(true);


        ListOfMenuDishes originalListOfMenuDishes = new ListOfMenuDishes();
        originalListOfMenuDishes.setMenuDishes(List.of(originalMenuDish1, originalMenuDish2));

        ListOfMenuDishes testListOfMenuDishes;
        JsonParser jsonParser = new JsonParser();
        Path path = FileSystems.getDefault().getPath("src/test/resources/inputForTest/menuDishesJsonsForTest/menu_dishes.json");
        testListOfMenuDishes = jsonParser.getListOfMenuDishesFromJson(path);
        Assertions.assertEquals(testListOfMenuDishes, originalListOfMenuDishes);
    }

    @Test
    void getListOfMenuDishesFromJsonTestNotCorrectJson() throws IOException {
        MenuDish originalMenuDish1 = new MenuDish();
        originalMenuDish1.setMenuDishId(28);
        originalMenuDish1.setMenuDishCard(534);
        originalMenuDish1.setMenuDishPrice(59);
        originalMenuDish1.setMenuDishActive(true);


        MenuDish originalMenuDish2 = new MenuDish();
        originalMenuDish2.setMenuDishId(34);
        originalMenuDish2.setMenuDishCard(36);
        originalMenuDish2.setMenuDishPrice(100);
        originalMenuDish2.setMenuDishActive(false);


        ListOfMenuDishes originalListOfMenuDishes = new ListOfMenuDishes();
        originalListOfMenuDishes.setMenuDishes(List.of(originalMenuDish1, originalMenuDish2));

        ListOfMenuDishes testListOfMenuDishes;
        JsonParser jsonParser = new JsonParser();
        Path path = FileSystems.getDefault().getPath("src/test/resources/inputForTest/menuDishesJsonsForTest/menu_dishes.json");
        testListOfMenuDishes = jsonParser.getListOfMenuDishesFromJson(path);
        Assertions.assertNotEquals(testListOfMenuDishes, originalListOfMenuDishes);
    }

    @Test()
    void testGetListOfDishCardsFromJsonTestCorrectJson() throws IOException {
        JsonParser jsonParser = new JsonParser();
        Path path = FileSystems.getDefault().getPath("src", "test", "resources", "inputForTest", "dishCardsJsonsForTest", "dish_cards.json");
        var listOfDishCards = jsonParser.getListOfDishCardsFromJson(path);
        List<DishCard> dishCardList = new ArrayList<>();

        List<DishCardsOperations> dishCardsOperationsList = new ArrayList<>();
        List<DishCardsOperationsProducts> operationsProducts = List.of(
                new DishCardsOperationsProducts(18, 1),
                new DishCardsOperationsProducts(23, 2),
                new DishCardsOperationsProducts(24, 0),
                new DishCardsOperationsProducts(12, 1),
                new DishCardsOperationsProducts(19, 1));
        dishCardsOperationsList.add(new DishCardsOperations(17, 25, 0.15, 0, operationsProducts));

        dishCardList.add(new DishCard(
                518,
                "Princess Nuri tea bag in a paper cup",
                "pouring boiled water into a paper cup + 2 bags of sugar",
                3.0,
                25,
                dishCardsOperationsList
                ));

        ListOfDishCards result = new ListOfDishCards(dishCardList);
        Assertions.assertEquals(result, listOfDishCards);
    }

    @Test()
    @DisplayName("test get ListOfDishCards From Json " +
            "and compare it with other not equals ListOfDishCards object should return false")
    void testGetListOfDishCardsFromJsonTestNotCorrectJson() throws IOException {
        JsonParser jsonParser = new JsonParser();
        Path path = FileSystems.getDefault().getPath("src", "test", "resources", "inputForTest", "dishCardsJsonsForTest", "dish_cards.json");
        var listOfDishCards = jsonParser.getListOfDishCardsFromJson(path);
        List<DishCard> dishCardList = new ArrayList<>();

        List<DishCardsOperations> dishCardsOperationsList = new ArrayList<>();
        List<DishCardsOperationsProducts> operationsProducts = List.of(
                new DishCardsOperationsProducts(7, 1),
                new DishCardsOperationsProducts(77, 2),
                new DishCardsOperationsProducts(777, 0),
                new DishCardsOperationsProducts(123, 1),
                new DishCardsOperationsProducts(19, 10));
        dishCardsOperationsList.add(new DishCardsOperations(17, 25, 0.15, 0, operationsProducts));

        dishCardList.add(new DishCard(
                518,
                "Princess Nuri tea bag in a paper cup",
                "pouring boiled water into a paper cup + 2 bags of sugar",
                3.0,
                25,
                dishCardsOperationsList
        ));

        ListOfDishCards result = new ListOfDishCards(dishCardList);
        Assertions.assertNotEquals(result, listOfDishCards);
    }

    @Test
    @DisplayName("test get ListOfCooksFrom From Json " +
            "and compare it with other not equals ListOfCooksFrom object should return false")
    void testGetListOfCooksFromJsonTestCorrectJson() throws IOException {
        JsonParser jsonParser = new JsonParser();
        Path path = FileSystems.getDefault().getPath("src", "test", "resources", "inputForTest", "cooksJsonsForTest", "cooks.json");
        var listOfCooksFromJson = jsonParser.getListOfCooksFromJson(path);

        List<Cook> cookList = List.of(
                new Cook(15, "Ivanov A. S.", true),
                new Cook(16, "Petrov I. V.", true),
                new Cook(14, "Sidorov G. S.", false));
        ListOfCooks result = new ListOfCooks(cookList);

        Assertions.assertEquals(result, listOfCooksFromJson);
    }

    @Test
    void testGetListOfCooksFromJsonTestNotCorrectJson() throws IOException {
        JsonParser jsonParser = new JsonParser();
        Path path = FileSystems.getDefault().getPath("src", "test", "resources", "inputForTest", "cooksJsonsForTest", "cooks.json");
        var listOfCooksFromJson = jsonParser.getListOfCooksFromJson(path);

        List<Cook> cookList = List.of(
                new Cook(7, "Chesnokov S. A.", true),
                new Cook(8, "Petrov I. V.", true),
                new Cook(9, "Sidorov G. S.", false));
        ListOfCooks result = new ListOfCooks(cookList);

        Assertions.assertNotEquals(result, listOfCooksFromJson);
    }

}