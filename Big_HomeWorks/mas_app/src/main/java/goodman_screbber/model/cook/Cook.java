package goodman_screbber.model.cook;

import com.fasterxml.jackson.annotation.JsonProperty;
import goodman_screbber.model.order.log.OrderDishCardForLog;
import goodman_screbber.model.order.log.VisitorOrderForLog;
import goodman_screbber.model.visitor.orders.VisitorOrder;
import goodman_screbber.model.dish.cards.DishCard;

import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Cook implements Runnable {
    private VisitorOrderForLog currentVisitorOrderForLog;
    private VisitorOrder currentVisitorOrder;
    private DishCard currentDishCard;

    @JsonProperty("cook_id")
    private Integer cookId;

    @JsonProperty("cook_name")
    private String cookName;

    @JsonProperty("cook_active")
    private boolean cookActive;

    public Cook(DishCard currentDishCard, Integer cookId, String cookName, boolean cookActive) {
        this.currentDishCard = currentDishCard;
        this.cookId = cookId;
        this.cookName = cookName;
        this.cookActive = cookActive;
    }

    public Cook(VisitorOrder currentVisitorOrder, VisitorOrderForLog currentVisitorOrderForLog,
                DishCard currentDishCard) {
        this.currentVisitorOrder = currentVisitorOrder;
        this.currentVisitorOrderForLog = currentVisitorOrderForLog;
        this.currentDishCard = currentDishCard;
    }

    public Cook(Integer cookId, String cookName, boolean cookActive) {
        this.cookId = cookId;
        this.cookName = cookName;
        this.cookActive = cookActive;
    }

    public Cook() {
    }

    public Integer getCookId() {
        return cookId;
    }

    public void setCookId(Integer cookId) {
        this.cookId = cookId;
    }

    public String getCookName() {
        return cookName;
    }

    public void setCookName(String cookName) {
        this.cookName = cookName;
    }

    public boolean isCookActive() {
        return cookActive;
    }

    public void setCookActive(boolean cookActive) {
        this.cookActive = cookActive;
    }

    /**
     * Запускает приготовление блюда, если оно последнее из неприготовленных блюд в заказе,
     * то устанавливает время окончания всего заказа
     */
    @Override
    public void run() {
        System.out.println("Start cooking order: " + currentVisitorOrder.getVis_name());
        System.out.println("Start cooking dish: " + currentDishCard.getCard_descr());
        try {

            Thread.sleep(currentDishCard.getCardTime().intValue() * 1000L);

            OrderDishCardForLog orderDishCardForLog = new OrderDishCardForLog(currentDishCard.getDishName(),
                    currentDishCard.getCardId());


            currentVisitorOrderForLog.addOrderDishCardForLog(orderDishCardForLog);

            if (currentVisitorOrder.decrementAndGetNumberOfNotCookingDishes() == 0) {

                LocalDateTime finishCookingTime = LocalDateTime.now();

                var durationOfCookingOrder = ChronoUnit.SECONDS.
                        between(currentVisitorOrder.getStartCookingRealTime(), finishCookingTime);

                System.out.println("DONE " + currentVisitorOrder.getVis_name());

                LocalDateTime finished = currentVisitorOrder.getVis_ord_started().plusSeconds(durationOfCookingOrder);
                System.out.println("finished at: " + finished);

                currentVisitorOrderForLog.setVisitorOrderFinished(finished);
            }
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cook cook)) return false;

        if (cookActive != cook.cookActive) return false;
        if (!cookId.equals(cook.cookId)) return false;
        return cookName.equals(cook.cookName);
    }

    @Override
    public int hashCode() {
        int result = cookId.hashCode();
        result = 31 * result + cookName.hashCode();
        result = 31 * result + (cookActive ? 1 : 0);
        return result;
    }
}
