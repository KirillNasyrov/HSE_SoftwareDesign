package goodman_screbber.model.product;

import java.util.ArrayList;
import java.util.List;

public class ListOfProducts {
    private List<Product> products;

    public ListOfProducts(List<Product> products) {
        this.products = new ArrayList<>(products);
    }

    public ListOfProducts() {
    }

    public List<Product> getProducts() {
        return products;
    }

    public void setProducts(List<Product> products) {
        this.products = new ArrayList<>(products);
    }
}