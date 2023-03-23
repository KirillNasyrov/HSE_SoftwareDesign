package model;

public class DishCardsOperationsProducts {
    Integer prod_type;
    Integer prod_quantity;

    public DishCardsOperationsProducts() {
    }

    public DishCardsOperationsProducts(Integer prod_type, Integer prod_quantity) {
        this.prod_type = prod_type;
        this.prod_quantity = prod_quantity;
    }

    public Integer getProd_type() {
        return prod_type;
    }

    public void setProd_type(Integer prod_type) {
        this.prod_type = prod_type;
    }

    public Integer getProd_quantity() {
        return prod_quantity;
    }

    public void setProd_quantity(Integer prod_quantity) {
        this.prod_quantity = prod_quantity;
    }
}
