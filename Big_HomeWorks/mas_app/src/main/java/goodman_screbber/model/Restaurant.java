package goodman_screbber.model;

import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import goodman_screbber.model.cook.ListOfCooks;
import goodman_screbber.model.menu.ListOfMenuDishes;
import goodman_screbber.model.order.log.NotFoundDishCardErrorForLog;
import goodman_screbber.model.order.log.VisitorOrderForLog;
import goodman_screbber.model.visitor.orders.VisitorOrder;
import goodman_screbber.model.cook.Cook;
import goodman_screbber.model.dish.cards.DishCard;
import goodman_screbber.model.dish.cards.ListOfDishCards;
import goodman_screbber.model.menu.MenuDish;
import goodman_screbber.model.visitor.orders.ListOfVisitorOrders;
import goodman_screbber.model.visitor.orders.OrderDish;

import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;
import java.util.concurrent.*;

public class Restaurant {
    private final List<VisitorOrderForLog> visitorOrderForLogList = new ArrayList<>();
    private final List<NotFoundDishCardErrorForLog> errorsForLogList = new ArrayList<>();
    private final ListOfMenuDishes listOfMenuDishes;
    private final List<VisitorOrder> visitorOrderList = new ArrayList<>();
    private final ExecutorService threadPool;
    private final ObjectMapper objectMapper = new ObjectMapper();
    private final ListOfDishCards listOfDishCards;
    private final ListOfCooks listOfCooks;
    private final ObjectWriter writer;

    public Restaurant(ListOfVisitorOrders listOfOrders, ListOfMenuDishes listOfMenuDishes,
                      ListOfDishCards listOfDishCards, ListOfCooks listOfCooks) {

        this.listOfCooks = listOfCooks;
        threadPool = Executors.newFixedThreadPool(listOfCooks.getCooks().size());
        visitorOrderList.addAll(listOfOrders.getVisitors_orders());
        visitorOrderList.sort(Comparator.comparing(VisitorOrder::getVis_ord_started));

        for (int i = 0; i < visitorOrderList.size(); ++i) {
            var order = visitorOrderList.get(i);
            visitorOrderForLogList.add(new VisitorOrderForLog(order.getVis_name(), order.getVis_ord_started()));
        }

        this.listOfMenuDishes = listOfMenuDishes;
        this.listOfDishCards = listOfDishCards;
        for (VisitorOrder visitorsOrder : visitorOrderList) {
            visitorsOrder.initNumberOfNotCookingDishes();
        }

        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        writer = objectMapper.writer(new DefaultPrettyPrinter());
    }

    /**
     * Делает поиск по id меню соответвующую карточку блюда
     * @param menuId id меню
     */
    public Optional<DishCard> findDishCardFromMenuById(Integer menuId) {
        for (MenuDish menuDish : listOfMenuDishes.getMenuDishes()) {
            if (menuDish.getMenuDishId() == menuId) {
                Integer menuDishCardId = menuDish.getMenuDishCard();
                for (var dishCard : listOfDishCards.getDishCards()) {
                    if (dishCard.getCardId().equals(menuDishCardId)) {
                        return Optional.of(dishCard);
                    }
                }
            }
        }

        errorsForLogList.add(new NotFoundDishCardErrorForLog(menuId));
        return Optional.empty();
    }

    /**
     * Записывает логи заказов и ощибок во время роботы
     */
    private void writeJsonLogs() {
        try {
            writer.writeValue(Paths.get("errorLogs.json").toFile(), errorsForLogList);
            writer.writeValue(Paths.get("orderLogs.json").toFile(), visitorOrderForLogList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * Метод, запускающий приготовление всех заказов
     */
    public void startWorking() throws InterruptedException {
        for (int i = 0; i < visitorOrderList.size(); i++) {
            visitorOrderList.get(i).setStartCookingRealTime(LocalDateTime.now());
            if (i != visitorOrderList.size() - 1) {

                for (OrderDish orderDish : visitorOrderList.get(i).getVis_ord_dishes()) {
                    Optional<DishCard> currentDishCard = findDishCardFromMenuById(orderDish.getMenu_dish());

                    if (currentDishCard.isPresent()) {
                        threadPool.submit(new Cook(visitorOrderList.get(i), visitorOrderForLogList.get(i),
                                currentDishCard.get()));
                    }
                }

                var timeSimulationUntilNextOrder = ChronoUnit.MILLIS
                        .between(visitorOrderList.get(i).getVis_ord_started(), visitorOrderList.get(i + 1).getVis_ord_started());

                Thread.sleep(timeSimulationUntilNextOrder);
            } else {
                for (OrderDish orderDish : visitorOrderList.get(i).getVis_ord_dishes()) {

                    Optional<DishCard> currentDishCard = findDishCardFromMenuById(orderDish.getMenu_dish());

                    if (currentDishCard.isPresent()) {
                        threadPool.submit(new Cook(visitorOrderList.get(i), visitorOrderForLogList.get(i),
                                currentDishCard.get()));
                    }
                }
            }
        }
        writeJsonLogs();
    }

    /**
     * Завершает работу ресторана
     * @throws InterruptedException
     */
    public void stopWorking() throws InterruptedException {
        threadPool.shutdown();
        threadPool.awaitTermination(10, TimeUnit.SECONDS);
    }
}
