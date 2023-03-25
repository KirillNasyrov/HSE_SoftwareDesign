package model;

import model.dishCards.ListOfDishes;
import model.menu.ListOfMenuDishes;
import model.visitorOrders.ListOfVisitorOrders;
import model.visitorOrders.VisitorOrder;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class Restaurant {
    private final ListOfMenuDishes listOfMenuDishes;
    private final BlockingQueue<VisitorOrder> orderQueue = new LinkedBlockingQueue<>();

    public Restaurant(ListOfVisitorOrders listOfOrders, ListOfMenuDishes listOfMenuDishes) {
        orderQueue.addAll(listOfOrders.getVisitors_orders());
        this.listOfMenuDishes = listOfMenuDishes;
    }


}
