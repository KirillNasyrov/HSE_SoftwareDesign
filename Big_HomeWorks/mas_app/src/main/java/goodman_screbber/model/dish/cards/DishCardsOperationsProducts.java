package goodman_screbber.model.dish.cards;

import com.fasterxml.jackson.annotation.JsonProperty;

public class DishCardsOperationsProducts {
    @JsonProperty("prod_type")
    Integer productType;

    @JsonProperty("prod_quantity")
    Integer productQuantity;

    public DishCardsOperationsProducts() {
    }

    public DishCardsOperationsProducts(Integer productType, Integer productQuantity) {
        this.productType = productType;
        this.productQuantity = productQuantity;
    }

    public Integer getProductType() {
        return productType;
    }

    public void setProductType(Integer productType) {
        this.productType = productType;
    }

    public Integer getProductQuantity() {
        return productQuantity;
    }

    public void setProductQuantity(Integer productQuantity) {
        this.productQuantity = productQuantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DishCardsOperationsProducts that)) return false;

        if (!productType.equals(that.productType)) return false;
        return productQuantity.equals(that.productQuantity);
    }

    @Override
    public int hashCode() {
        int result = productType.hashCode();
        result = 31 * result + productQuantity.hashCode();
        return result;
    }
}
