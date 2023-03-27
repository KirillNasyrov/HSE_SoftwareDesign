package goodman_screbber.model.orderLog;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class VisitorOrderForLog {
    private String nameOfVisitor;
    private LocalDateTime visitorOrderStarted;
    private LocalDateTime visitorOrderFinished;
    private List<OrderDishCardForLog> dishesOfOrder;

    public VisitorOrderForLog(String nameOfVisitor, LocalDateTime visitorOrderStarted) {
        this.nameOfVisitor = nameOfVisitor;
        this.visitorOrderStarted = visitorOrderStarted;
        dishesOfOrder = new ArrayList<>();
    }

    public VisitorOrderForLog() {
    }

    public void addOrderDishCardForLog(OrderDishCardForLog orderDishCardForLog) {
        dishesOfOrder.add(orderDishCardForLog);
    }

    public void setVisitorOrderFinished(LocalDateTime visitorOrderFinished) {
        this.visitorOrderFinished = visitorOrderFinished;
    }
    public LocalDateTime getVisitorOrderStarted() {
        return visitorOrderStarted;
    }
    public String getNameOfVisitor() {
        return nameOfVisitor;
    }
    public void setNameOfVisitor(String nameOfVisitor) {
        this.nameOfVisitor = nameOfVisitor;
    }
    public void setVisitorOrderStarted(LocalDateTime visitorOrderStarted) {
        this.visitorOrderStarted = visitorOrderStarted;
    }
    public LocalDateTime getVisitorOrderFinished() {
        return visitorOrderFinished;
    }
    public List<OrderDishCardForLog> getDishesOfOrder() {
        return new ArrayList<>(dishesOfOrder);
    }
    public void setDishesOfOrder(List<OrderDishCardForLog> dishesOfOrder) {
        this.dishesOfOrder = new ArrayList<>(dishesOfOrder);
    }
}
