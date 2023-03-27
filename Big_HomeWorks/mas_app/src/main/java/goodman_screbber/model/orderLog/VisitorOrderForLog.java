package goodman_screbber.model.orderLog;

import java.time.LocalDateTime;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

public class VisitorOrderForLog {
    private String nameOfVisitor;
    private LocalDateTime visitorOrderStarted;
    private LocalDateTime visitorOrderFinished;

    private BlockingQueue<OrderDishCardForLog> dishesOfOrder;

    public VisitorOrderForLog(String nameOfVisitor, LocalDateTime visitorOrderStarted) {
        this.nameOfVisitor = nameOfVisitor;
        this.visitorOrderStarted = visitorOrderStarted;
        dishesOfOrder = new LinkedBlockingQueue<>();
    }

    public VisitorOrderForLog() {
    }

    public void addOrderDishCardForLog(OrderDishCardForLog orderDishCardForLog) {
        dishesOfOrder.add(orderDishCardForLog);
    }
    public BlockingQueue<OrderDishCardForLog> getDishesOfOrder() {
        return new LinkedBlockingQueue<>(dishesOfOrder);
    }

    public void setDishesOfOrder(BlockingQueue<OrderDishCardForLog> dishesOfOrder) {
        this.dishesOfOrder = new LinkedBlockingQueue<>(dishesOfOrder);
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
}
