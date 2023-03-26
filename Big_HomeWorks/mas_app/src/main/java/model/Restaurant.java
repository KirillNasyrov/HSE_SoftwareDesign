package model;

import model.cook.Cook;
import model.dishCards.DishCard;
import model.dishCards.ListOfDishCards;
import model.menu.ListOfMenuDishes;
import model.menu.MenuDish;
import model.visitorOrders.ListOfVisitorOrders;
import model.visitorOrders.OrderDish;
import model.visitorOrders.VisitorOrder;

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
    // private final BlockingQueue<VisitorOrder> orderQueue = new LinkedBlockingQueue<>();
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
//        for (VisitorOrder order : orderQueue) {
//            BlockingQueue<DishCard> currentOrder = new LinkedBlockingQueue<>();
//            for (OrderDish orderDish : order.getVis_ord_dishes()) {
//                currentOrder.add(findDishCardFromMenuById(orderDish.getMenu_dish()));
//            }
//            while (!currentOrder.isEmpty()) {
//                threadPool.submit(new Cook(order, currentOrder.take(), orderFinishQueue));
//            }
//        }

        for (int i = 0; i < orderQueue.size(); i++) {
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
