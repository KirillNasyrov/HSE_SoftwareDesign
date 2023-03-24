package model;

public class ProductType {
    private Integer prod_type_id;
    private String prod_type_name;
    private Boolean prod_is_food;

    public ProductType(Integer prod_type_id, String prod_type_name, Boolean prod_is_food) {
        this.prod_type_id = prod_type_id;
        this.prod_type_name = prod_type_name;
        this.prod_is_food = prod_is_food;
    }

    public ProductType() {
    }

    public Integer getProd_type_id() {
        return prod_type_id;
    }

    public void setProd_type_id(Integer prod_type_id) {
        this.prod_type_id = prod_type_id;
    }

    public String getProd_type_name() {
        return prod_type_name;
    }

    public void setProd_type_name(String prod_type_name) {
        this.prod_type_name = prod_type_name;
    }

    public Boolean getProd_is_food() {
        return prod_is_food;
    }

    public void setProd_is_food(Boolean prod_is_food) {
        this.prod_is_food = prod_is_food;
    }
}
