package model;

import java.util.List;

public class DIshCardsOperations {
    private Integer oper_type;
    private Double oper_time;
    private Integer oper_async_point;
    private List<DishCardsOperationProducts> oper_products;

    public Integer getOper_type() {
        return oper_type;
    }

    public void setOper_type(Integer oper_type) {
        this.oper_type = oper_type;
    }

    public Double getOper_time() {
        return oper_time;
    }

    public void setOper_time(Double oper_time) {
        this.oper_time = oper_time;
    }

    public Integer getOper_async_point() {
        return oper_async_point;
    }

    public void setOper_async_point(Integer oper_async_point) {
        this.oper_async_point = oper_async_point;
    }

    public List<DishCardsOperationProducts> getOper_products() {
        return oper_products;
    }

    public void setOper_products(List<DishCardsOperationProducts> oper_products) {
        this.oper_products = oper_products;
    }
}
