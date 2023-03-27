package goodman_screbber.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.util.DefaultPrettyPrinter;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import goodman_screbber.model.menu.ListOfMenuDishes;
import goodman_screbber.model.orderLog.VisitorOrderForLog;
import goodman_screbber.model.visitorOrders.VisitorOrder;
import goodman_screbber.model.cook.Cook;
import goodman_screbber.model.dishCards.DishCard;
import goodman_screbber.model.dishCards.ListOfDishCards;
import goodman_screbber.model.menu.MenuDish;
import goodman_screbber.model.visitorOrders.ListOfVisitorOrders;
import goodman_screbber.model.visitorOrders.OrderDish;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.*;

public class Restaurant {
    private final ListOfMenuDishes listOfMenuDishes;
    private final List<VisitorOrder> visitorOrderList = new ArrayList<>();
    private final List<VisitorOrderForLog> visitorOrderForLogList = new ArrayList<>();
    private final BlockingQueue<VisitorOrderForLog> orderForLogQueue = new LinkedBlockingQueue<>();
    private final ExecutorService threadPool = Executors.newFixedThreadPool(3);


    private final ListOfDishCards listOfDishCards;

    public Restaurant(ListOfVisitorOrders listOfOrders,
                      ListOfMenuDishes listOfMenuDishes,
                      ListOfDishCards listOfDishCards) {
        visitorOrderList.addAll(listOfOrders.getVisitors_orders());

        for (int i = 0; i < listOfOrders.getVisitors_orders().size(); ++i) {
            var order = listOfOrders.getVisitors_orders().get(i);
            visitorOrderForLogList.add(new VisitorOrderForLog(order.getVis_name(), order.getVis_ord_started()));
        }

        this.listOfMenuDishes = listOfMenuDishes;
        this.listOfDishCards = listOfDishCards;
        for (VisitorOrder visitorsOrder : listOfOrders.getVisitors_orders()) {
            visitorsOrder.initNumberOfNotCookingDishes();
        }
    }

    public DishCard findDishCardFromMenuById(Integer menuId) {
        for (MenuDish menuDish : listOfMenuDishes.getMenu_dishes()) {
            if (menuDish.getMenu_dish_id() == menuId) {
                Integer menuDishCardId = menuDish.getMenu_dish_card();
                for (var dishCard : listOfDishCards.getDish_cards()) {
                    if (dishCard.getCard_id().equals(menuDishCardId)) {
                        return dishCard;
                    }
                }
            }
        }
        throw new NoSuchElementException();
    }

    public void startCooking() throws InterruptedException {
        for (int i = 0; i < visitorOrderList.size(); i++) {
            visitorOrderList.get(i).setStartCookingRealTime(LocalDateTime.now());
            if (i != visitorOrderList.size() - 1) {

                for (OrderDish orderDish : visitorOrderList.get(i).getVis_ord_dishes()) {
                    DishCard currentDishCard = findDishCardFromMenuById(orderDish.getMenu_dish());
                    threadPool.submit(new Cook(visitorOrderList.get(i), visitorOrderForLogList.get(i),
                            currentDishCard, orderForLogQueue));
                }

                var timeSimulationUntilNextOrder = ChronoUnit.MILLIS
                        .between(visitorOrderList.get(i).getVis_ord_started(), visitorOrderList.get(i + 1).getVis_ord_started());

                Thread.sleep(timeSimulationUntilNextOrder);
            } else {
                for (OrderDish orderDish : visitorOrderList.get(i).getVis_ord_dishes()) {

                    DishCard currentDishCard = findDishCardFromMenuById(orderDish.getMenu_dish());

                    threadPool.submit(new Cook(visitorOrderList.get(i), visitorOrderForLogList.get(i),
                            currentDishCard, orderForLogQueue));
                }
            }
        }
        threadPool.shutdown();
        threadPool.awaitTermination(10, TimeUnit.SECONDS);
        // Thread.sleep(1000);
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.registerModule(new JavaTimeModule());
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
        ObjectWriter writer = objectMapper.writer(new DefaultPrettyPrinter());

        try {
            writer.writeValue(Paths.get("res.json").toFile(), visitorOrderForLogList);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
