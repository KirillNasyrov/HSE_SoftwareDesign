package model.visitorOrders;

import java.util.ArrayList;
import java.util.List;

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
}
