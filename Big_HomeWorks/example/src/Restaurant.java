/*import java.time.LocalDateTime;
import java.util.*;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.atomic.AtomicInteger;

public class Main {
    private static final ExecutorService threadPool = Executors.newFixedThreadPool(5);

    public static void main(String[] args) throws InterruptedException {
        List<Order> listOrder = new ArrayList<>();
        List<Dish> dishList = List.of(new Dish(0, 1000), new Dish(1, 2000), new Dish(2, 3000));
        listOrder.add(new Order(0, dishList));
        listOrder.add(new Order(1, dishList));

        for (Order order : listOrder) {
            var time = LocalDateTime.now();

            List<Callable<String>> tasks = new ArrayList<>();
            for (Dish dish : order.getDishList()) {
                tasks.add()
                threadPool.submit(new Cook(order, dish));
            }
        }


    }
}

class Order {
    private AtomicInteger counter;
    private int id;
    private final List<Dish> dishList;



    public Order(int id, List<Dish> dishList) {
        this.id = id;
        this.dishList = dishList;
        counter = new AtomicInteger(this.dishList.size());
    }

    public int getId() {
        return id;
    }

    public int getAndDecCounter() {
        return counter.decrementAndGet();
    }


    public List<Dish> getDishList() {
        return dishList;
    }
}

class Dish {
    int id;
    int time;

    public Dish(int id, int time) {
        this.id = id;
        this.time = time;
    }

    public int getId() {
        return id;
    }
}

class Cook implements Runnable {
    private Order currentOrder;
    private Dish currentDish;


    public Cook(Order currentOrder, Dish currentDish) {
        this.currentOrder = currentOrder;
        this.currentDish = currentDish;
    }

    @Override
    public void run() {
        System.out.println("Start cooking order: " + currentOrder.getId());
        System.out.println("Start cooking dish: " + currentDish.getId());
        try {
            Thread.sleep(currentDish.time);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            if (currentOrder.getAndDecCounter() == 0) {
                System.out.println(LocalDateTime.now());
                System.out.println("DONE");
            }
        }
    }
}*/

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;

public class Restaurant {
    private ExecutorService executorService;
    private List<Order> orders;

    public Restaurant(int numCooks) {
        executorService = Executors.newFixedThreadPool(numCooks);
        orders = new ArrayList<>();
    }

    public void addOrder(Order order) {
        orders.add(order);
    }

    public void start() throws InterruptedException {
        List<Callable<Void>> callables = new ArrayList<>();
        for (Order order : orders) {
            callables.add(() -> {
                for (Dish dish : order.getDishes()) {
                    cookDish(dish);
                }
                System.out.println("Order " + order.getId() + " is ready");
                return null;
            });
        }
        executorService.invokeAll(callables);
        executorService.shutdown();
    }

    private void cookDish(Dish dish) throws InterruptedException {
        System.out.println("Cooking dish " + dish.getName() + " for order " + dish.getOrderId());
        Thread.sleep(dish.getTimeToCook());
        System.out.println("Finished cooking dish " + dish.getName() + " for order " + dish.getOrderId());
    }

    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Restaurant restaurant = new Restaurant(5);
        restaurant.addOrder(new Order(1, Arrays.asList(
                new Dish(1, "Pasta", 5000),
                new Dish(1, "Salad", 5000),
                new Dish(1, "Steak", 5000)
        )));
        restaurant.addOrder(new Order(2, Arrays.asList(
                new Dish(2, "Soup", 5000),
                new Dish(2, "Fish", 5000)
        )));
        restaurant.start();
    }
}

class Order {
    private int id;
    private List<Dish> dishes;

    public Order(int id, List<Dish> dishes) {
        this.id = id;
        this.dishes = dishes;
    }

    public int getId() {
        return id;
    }

    public List<Dish> getDishes() {
        return dishes;
    }
}

class Dish {
    private int orderId;
    private String name;
    private int timeToCook;

    public Dish(int orderId, String name, int timeToCook) {
        this.orderId = orderId;
        this.name = name;
        this.timeToCook = timeToCook;
    }

    public int getOrderId() {
        return orderId;
    }

    public String getName() {
        return name;
    }

    public int getTimeToCook() {
        return timeToCook;
    }
}