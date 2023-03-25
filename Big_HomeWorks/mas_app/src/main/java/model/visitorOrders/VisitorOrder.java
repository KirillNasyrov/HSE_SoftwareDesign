package model.visitorOrders;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class VisitorOrder {
    private String vis_name;
    private Date vis_ord_started;
    private Date vis_ord_ended;
    private Integer vis_ord_total;
    private List<OrderDish> vis_ord_dishes;

    @JsonIgnore
    private Double totalTimeOfCooking;

    public VisitorOrder(String vis_name, Date vis_ord_started, Date vis_ord_ended,
                        Integer vis_ord_total, List<OrderDish> vis_ord_dishes) {
        this.vis_name = vis_name;
        this.vis_ord_started = vis_ord_started;
        this.vis_ord_ended = vis_ord_ended;
        this.vis_ord_total = vis_ord_total;
        this.vis_ord_dishes = new ArrayList<>(vis_ord_dishes);
        //totalTimeOfCooking = vis_ord_dishes.stream().mapToDouble(dish -> dish.getCookingTime())
    }

    public VisitorOrder() {
    }

    public String getVis_name() {
        return vis_name;
    }

    public void setVis_name(String vis_name) {
        this.vis_name = vis_name;
    }

    public Date getVis_ord_started() {
        return vis_ord_started;
    }

    public void setVis_ord_started(Date vis_ord_started) {
        this.vis_ord_started = vis_ord_started;
    }

    public Date getVis_ord_ended() {
        return vis_ord_ended;
    }

    public void setVis_ord_ended(Date vis_ord_ended) {
        this.vis_ord_ended = vis_ord_ended;
    }

    public Integer getVis_ord_total() {
        return vis_ord_total;
    }

    public void setVis_ord_total(Integer vis_ord_total) {
        this.vis_ord_total = vis_ord_total;
    }

    public List<OrderDish> getVis_ord_dishes() {
        return new ArrayList<>(vis_ord_dishes);
    }

    public void setVis_ord_dishes(List<OrderDish> vis_ord_dishes) {
        this.vis_ord_dishes = new ArrayList<>(vis_ord_dishes);
    }
}
