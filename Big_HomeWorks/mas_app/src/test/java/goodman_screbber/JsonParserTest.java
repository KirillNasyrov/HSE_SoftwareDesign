package goodman_screbber;

import goodman_screbber.model.cook.Cook;
import goodman_screbber.model.cook.ListOfCooks;
import goodman_screbber.model.dishCards.DishCard;
import goodman_screbber.model.dishCards.DishCardsOperations;
import goodman_screbber.model.dishCards.DishCardsOperationsProducts;
import goodman_screbber.model.dishCards.ListOfDishCards;
import goodman_screbber.model.visitorOrders.ListOfVisitorOrders;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class JsonParserTest {

    @Test
    void getListOfVisitorOrdersFromJson() {
        JsonParser jsonParser = new JsonParser();

    }

    @Test
    void getListOfMenuDishesFromJson() {

    }

    @Test()
    void testGetListOfDishCardsFromJsonShouldReturnTrue() throws IOException {
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
    void testGetListOfDishCardsFromJsonShouldReturnFalse() throws IOException {
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
    void testGetListOfCooksFromJsonShouldReturnTrue() throws IOException {
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
    void testGetListOfCooksFromJsonShouldReturnFalse() throws IOException {
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