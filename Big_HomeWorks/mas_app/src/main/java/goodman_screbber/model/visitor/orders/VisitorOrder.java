package goodman_screbber.model.visitor.orders;

import com.fasterxml.jackson.annotation.JsonIgnore;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;
import java.util.concurrent.atomic.AtomicInteger;

public class VisitorOrder {
    @JsonIgnore
    private AtomicInteger numberOfNotCookingDishes;

    @JsonIgnore
    private LocalDateTime startCookingRealTime;
    private String vis_name;
    private LocalDateTime vis_ord_started;
    private LocalDateTime vis_ord_ended;

    private Integer vis_ord_total;
    private List<OrderDish> vis_ord_dishes;


    public VisitorOrder(AtomicInteger numberOfNotCookingDishes, LocalDateTime startCookingTime, String vis_name,
                        LocalDateTime vis_ord_started, LocalDateTime vis_ord_ended,
                        Integer vis_ord_total, List<OrderDish> vis_ord_dishes) {
        this.numberOfNotCookingDishes = numberOfNotCookingDishes;
        this.startCookingRealTime = startCookingTime;
        this.vis_name = vis_name;
        this.vis_ord_started = vis_ord_started;
        this.vis_ord_ended = vis_ord_ended;
        this.vis_ord_total = vis_ord_total;
        this.vis_ord_dishes = vis_ord_dishes;
    }

    public VisitorOrder() {
    }

    public void initNumberOfNotCookingDishes() {
        numberOfNotCookingDishes = new AtomicInteger(vis_ord_dishes.size());
    }

    public int decrementAndGetNumberOfNotCookingDishes() {
        return numberOfNotCookingDishes.decrementAndGet();
    }

    public LocalDateTime getStartCookingRealTime() {
        return startCookingRealTime;
    }

    public void setStartCookingRealTime(LocalDateTime startCookingRealTime) {
        this.startCookingRealTime = startCookingRealTime;
    }

    public String getVis_name() {
        return vis_name;
    }

    public void setVis_name(String vis_name) {
        this.vis_name = vis_name;
    }

    public LocalDateTime getVis_ord_started() {
        return vis_ord_started;
    }

    public void setVis_ord_started(LocalDateTime vis_ord_started) {
        this.vis_ord_started = vis_ord_started;
    }

    public LocalDateTime getVis_ord_ended() {
        return vis_ord_ended;
    }

    public void setVis_ord_ended(LocalDateTime vis_ord_ended) {
        this.vis_ord_ended = vis_ord_ended;
    }

    public Integer getVis_ord_total() {
        return vis_ord_total;
    }

    public void setVis_ord_total(Integer vis_ord_total) {
        this.vis_ord_total = vis_ord_total;
    }

    public List<OrderDish> getVis_ord_dishes() {
        return vis_ord_dishes;
    }

    public void setVis_ord_dishes(List<OrderDish> vis_ord_dishes) {
        this.vis_ord_dishes = vis_ord_dishes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        VisitorOrder that = (VisitorOrder) o;

        if (!Objects.equals(numberOfNotCookingDishes, that.numberOfNotCookingDishes))
            return false;
        if (!Objects.equals(startCookingRealTime, that.startCookingRealTime))
            return false;
        if (!Objects.equals(vis_name, that.vis_name)) return false;
        if (!Objects.equals(vis_ord_started, that.vis_ord_started))
            return false;
        if (!Objects.equals(vis_ord_ended, that.vis_ord_ended))
            return false;
        if (!Objects.equals(vis_ord_total, that.vis_ord_total))
            return false;
        return Objects.equals(vis_ord_dishes, that.vis_ord_dishes);
    }

    @Override
    public int hashCode() {
        int result = numberOfNotCookingDishes != null ? numberOfNotCookingDishes.hashCode() : 0;
        result = 31 * result + (startCookingRealTime != null ? startCookingRealTime.hashCode() : 0);
        result = 31 * result + (vis_name != null ? vis_name.hashCode() : 0);
        result = 31 * result + (vis_ord_started != null ? vis_ord_started.hashCode() : 0);
        result = 31 * result + (vis_ord_ended != null ? vis_ord_ended.hashCode() : 0);
        result = 31 * result + (vis_ord_total != null ? vis_ord_total.hashCode() : 0);
        result = 31 * result + (vis_ord_dishes != null ? vis_ord_dishes.hashCode() : 0);
        return result;
    }
}
