package model.cook;

import model.visitorOrders.VisitorOrder;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.concurrent.BlockingQueue;

public class Cook implements Runnable {
    private VisitorOrder currentVisitorOrder;
    private Integer cook_id;
    private String cook_name;
    private boolean cook_active;

    public Cook(Integer cookId, String cookName) {
        cook_id = cookId;
        cook_name = cookName;
        cook_active = false;
    }

    public Cook() {
    }

    public void setCurrentVisitorOrder(VisitorOrder currentVisitorOrder) {
        this.currentVisitorOrder = currentVisitorOrder;
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



        System.out.println();
    }
}
