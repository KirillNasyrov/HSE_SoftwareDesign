package goodman_screbber.model.dish.cards;

import java.util.ArrayList;
import java.util.List;

public class DishCardsOperations {
    private Integer oper_type;
    private Integer equip_type;
    private Double oper_time;
    private Integer oper_async_point;
    private List<DishCardsOperationsProducts> oper_products;

    public DishCardsOperations(Integer oper_type, Integer equip_type, Double oper_time, Integer oper_async_point, List<DishCardsOperationsProducts> oper_products) {
        this.oper_type = oper_type;
        this.equip_type = equip_type;
        this.oper_time = oper_time;
        this.oper_async_point = oper_async_point;
        this.oper_products = oper_products;
    }

    public DishCardsOperations() {
    }

    public Integer getEquip_type() {
        return equip_type;
    }

    public void setEquip_type(Integer equip_type) {
        this.equip_type = equip_type;
    }

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

    public List<DishCardsOperationsProducts> getOper_products() {
        return new ArrayList<>(oper_products);
    }

    public void setOper_products(List<DishCardsOperationsProducts> oper_products) {
        this.oper_products = new ArrayList<>(oper_products);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DishCardsOperations that)) return false;

        if (!oper_type.equals(that.oper_type)) return false;
        if (!equip_type.equals(that.equip_type)) return false;
        if (!oper_time.equals(that.oper_time)) return false;
        if (!oper_async_point.equals(that.oper_async_point)) return false;
        return oper_products.equals(that.oper_products);
    }

    @Override
    public int hashCode() {
        int result = oper_type.hashCode();
        result = 31 * result + equip_type.hashCode();
        result = 31 * result + oper_time.hashCode();
        result = 31 * result + oper_async_point.hashCode();
        result = 31 * result + oper_products.hashCode();
        return result;
    }
}
