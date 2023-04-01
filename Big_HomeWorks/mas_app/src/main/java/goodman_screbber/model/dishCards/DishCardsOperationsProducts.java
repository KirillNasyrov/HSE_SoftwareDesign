package goodman_screbber.model.dishCards;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DishCardsOperationsProducts that)) return false;

        if (!prod_type.equals(that.prod_type)) return false;
        return prod_quantity.equals(that.prod_quantity);
    }

    @Override
    public int hashCode() {
        int result = prod_type.hashCode();
        result = 31 * result + prod_quantity.hashCode();
        return result;
    }
}
