package goodman_screbber.model.visitor.orders;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ListOfVisitorOrders {
    private List<VisitorOrder> visitors_orders;

    public ListOfVisitorOrders(List<VisitorOrder> visitorsOrders) {
        visitors_orders = new ArrayList<>(visitorsOrders);
    }

    public ListOfVisitorOrders() {
    }


    public List<VisitorOrder> getVisitors_orders() {
        return new ArrayList<>(visitors_orders);
    }

    public void setVisitors_orders(List<VisitorOrder> visitors_orders) {
        this.visitors_orders = new ArrayList<>(visitors_orders);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListOfVisitorOrders that = (ListOfVisitorOrders) o;

        return Objects.equals(visitors_orders, that.visitors_orders);
    }

    @Override
    public int hashCode() {
        return visitors_orders != null ? visitors_orders.hashCode() : 0;
    }
}
