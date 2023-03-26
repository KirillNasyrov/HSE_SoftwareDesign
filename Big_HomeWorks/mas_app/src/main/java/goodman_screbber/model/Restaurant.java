package goodman_screbber.model;

import goodman_screbber.model.menu.ListOfMenuDishes;
import goodman_screbber.model.visitorOrders.VisitorOrder;
import goodman_screbber.model.cook.Cook;
import goodman_screbber.model.dishCards.DishCard;
import goodman_screbber.model.dishCards.ListOfDishCards;
import goodman_screbber.model.menu.MenuDish;
import goodman_screbber.model.visitorOrders.ListOfVisitorOrders;
import goodman_screbber.model.visitorOrders.OrderDish;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {
    private final ListOfMenuDishes listOfMenuDishes;
    private final List<VisitorOrder> orderQueue = new ArrayList<>();
    private final BlockingQueue<VisitorOrder> orderFinishQueue = new LinkedBlockingQueue<>();
    private ExecutorService threadPool = Executors.newFixedThreadPool(3);


    private final ListOfDishCards listOfDishCards;

    public Restaurant(ListOfVisitorOrders listOfOrders,
                      ListOfMenuDishes listOfMenuDishes,
                      ListOfDishCards listOfDishCards) {
        orderQueue.addAll(listOfOrders.getVisitors_orders());
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
        for (int i = 0; i < orderQueue.size(); i++) {
            orderQueue.get(i).setStartCookingRealTime(LocalDateTime.now());
            if (i != orderQueue.size() - 1) {
                for (OrderDish orderDish : orderQueue.get(i).getVis_ord_dishes()) {
                    DishCard currentDish = findDishCardFromMenuById(orderDish.getMenu_dish());
                    threadPool.submit(new Cook(orderQueue.get(i), currentDish, orderFinishQueue));
                }
                var timeSimulationUntilNextOrder = ChronoUnit.MILLIS
                        .between(orderQueue.get(i).getVis_ord_started(), orderQueue.get(i + 1).getVis_ord_started());
                Thread.sleep(timeSimulationUntilNextOrder);
            } else {
                for (OrderDish orderDish : orderQueue.get(i).getVis_ord_dishes()) {
                    DishCard currentDish = findDishCardFromMenuById(orderDish.getMenu_dish());
                    threadPool.submit(new Cook(orderQueue.get(i), currentDish, orderFinishQueue));
                }
            }
        }
        threadPool.shutdown();
    }
}
