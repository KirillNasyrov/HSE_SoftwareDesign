package goodman_screbber.model.cook;

import goodman_screbber.model.visitorOrders.VisitorOrder;
import goodman_screbber.model.dishCards.DishCard;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.BlockingQueue;

public class Cook implements Runnable {
    private VisitorOrder currentVisitorOrder;
    private DishCard currentDish;
    private BlockingQueue<VisitorOrder> orderFinishQueue;
    private Integer cook_id;
    private String cook_name;
    private boolean cook_active;


    public Cook(DishCard currentDish, Integer cook_id, String cook_name, boolean cook_active) {
        this.currentDish = currentDish;
        this.cook_id = cook_id;
        this.cook_name = cook_name;
        this.cook_active = cook_active;
    }

    public Cook(VisitorOrder currentVisitorOrder, DishCard currentDish, BlockingQueue<VisitorOrder> orderFinishQueue) {
        this.currentVisitorOrder = currentVisitorOrder;
        this.currentDish = currentDish;
        this.orderFinishQueue = orderFinishQueue;
    }

    public Cook() {
    }

    public Integer getCook_id() {
        return cook_id;
    }

    public void setCook_id(Integer cook_id) {
        this.cook_id = cook_id;
    }

    public String getCook_name() {
        return cook_name;
    }

    public void setCook_name(String cook_name) {
        this.cook_name = cook_name;
    }

    public boolean isCook_active() {
        return cook_active;
    }

    public void setCook_active(boolean cook_active) {
        this.cook_active = cook_active;
    }

    @Override
    public void run() {
        System.out.println("Start cooking order: " + currentVisitorOrder.getVis_name());
        System.out.println("Start cooking dish: " + currentDish.getCard_descr());
        try {
            Thread.sleep(currentDish.getCard_time().intValue() * 1000L);
            if (currentVisitorOrder.decrementAndGetNumberOfNotCookingDishes() == 0) {
                LocalDateTime finishCookingTime = LocalDateTime.now();
                var durationOfCookingOrder = ChronoUnit.SECONDS.
                        between(currentVisitorOrder.getStartCookingRealTime(), finishCookingTime);
                System.out.println("DONE " + currentVisitorOrder.getVis_name());
                System.out.println(durationOfCookingOrder);
                System.out.println(currentVisitorOrder.getVis_ord_started().plusSeconds(durationOfCookingOrder));
                orderFinishQueue.add(currentVisitorOrder);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
