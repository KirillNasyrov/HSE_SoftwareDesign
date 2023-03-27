package goodman_screbber.model.cook;

import goodman_screbber.model.orderLog.OrderDishCardForLog;
import goodman_screbber.model.orderLog.VisitorOrderForLog;
import goodman_screbber.model.visitorOrders.VisitorOrder;
import goodman_screbber.model.dishCards.DishCard;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.concurrent.BlockingQueue;

public class Cook implements Runnable {
    private BlockingQueue<VisitorOrderForLog> orderForLogQueue;
    private VisitorOrderForLog currentVisitorOrderForLog;
    private VisitorOrder currentVisitorOrder;
    private DishCard currentDishCard;
    private Integer cook_id;
    private String cook_name;
    private boolean cook_active;


    public Cook(DishCard currentDishCard, Integer cook_id, String cook_name, boolean cook_active) {
        this.currentDishCard = currentDishCard;
        this.cook_id = cook_id;
        this.cook_name = cook_name;
        this.cook_active = cook_active;
    }

    public Cook(VisitorOrder currentVisitorOrder, VisitorOrderForLog currentVisitorOrderForLog,
                DishCard currentDishCard, BlockingQueue<VisitorOrderForLog> orderForLogQueue) {
        this.currentVisitorOrder = currentVisitorOrder;
        this.currentVisitorOrderForLog = currentVisitorOrderForLog;
        this.currentDishCard = currentDishCard;
        this.orderForLogQueue = orderForLogQueue;
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
        System.out.println("Start cooking dish: " + currentDishCard.getCard_descr());
        try {

            Thread.sleep(currentDishCard.getCard_time().intValue() * 1000L);

            OrderDishCardForLog orderDishCardForLog = new OrderDishCardForLog(currentDishCard.getDish_name(),
                    currentDishCard.getCard_id());

            currentVisitorOrderForLog.addOrderDishCardForLog(orderDishCardForLog);

            if (currentVisitorOrder.decrementAndGetNumberOfNotCookingDishes() == 0) {

                LocalDateTime finishCookingTime = LocalDateTime.now();

                var durationOfCookingOrder = ChronoUnit.SECONDS.
                        between(currentVisitorOrder.getStartCookingRealTime(), finishCookingTime);

                System.out.println("DONE " + currentVisitorOrder.getVis_name());
                //System.out.println(durationOfCookingOrder);

                LocalDateTime finished = currentVisitorOrder.getVis_ord_started().plusSeconds(durationOfCookingOrder);
                System.out.println(finished);

                currentVisitorOrderForLog.setVisitorOrderFinished(finished);
                //orderForLogQueue.add(currentVisitorOrderForLog);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
