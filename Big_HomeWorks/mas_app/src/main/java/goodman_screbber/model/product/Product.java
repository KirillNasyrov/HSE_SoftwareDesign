package goodman_screbber.model.product;

import java.util.Date;

public class Product {
    private Integer prod_item_id;
    private Integer prod_item_type;
    private String prod_item_name;
    private String prod_item_company;
    private String prod_item_unit;
    private double prod_item_quantity;
    private Integer prod_item_cost;
    private Date prod_item_delivered;
    private Date prod_item_valid_until;

    public Product(Integer prod_item_id, Integer prod_item_type, String prod_item_name,
                   String prod_item_company, String prod_item_unit, double prod_item_quantity,
                   Integer prod_item_cost, Date prod_item_delivered, Date prod_item_valid_until) {
        this.prod_item_id = prod_item_id;
        this.prod_item_type = prod_item_type;
        this.prod_item_name = prod_item_name;
        this.prod_item_company = prod_item_company;
        this.prod_item_unit = prod_item_unit;
        this.prod_item_quantity = prod_item_quantity;
        this.prod_item_cost = prod_item_cost;
        this.prod_item_delivered = prod_item_delivered;
        this.prod_item_valid_until = prod_item_valid_until;
    }

    public Product() {
    }

    public Integer getProd_item_id() {
        return prod_item_id;
    }

    public void setProd_item_id(Integer prod_item_id) {
        this.prod_item_id = prod_item_id;
    }

    public Integer getProd_item_type() {
        return prod_item_type;
    }

    public void setProd_item_type(Integer prod_item_type) {
        this.prod_item_type = prod_item_type;
    }

    public String getProd_item_name() {
        return prod_item_name;
    }

    public void setProd_item_name(String prod_item_name) {
        this.prod_item_name = prod_item_name;
    }

    public String getProd_item_company() {
        return prod_item_company;
    }

    public void setProd_item_company(String prod_item_company) {
        this.prod_item_company = prod_item_company;
    }

    public String getProd_item_unit() {
        return prod_item_unit;
    }

    public void setProd_item_unit(String prod_item_unit) {
        this.prod_item_unit = prod_item_unit;
    }

    public double getProd_item_quantity() {
        return prod_item_quantity;
    }

    public void setProd_item_quantity(double prod_item_quantity) {
        this.prod_item_quantity = prod_item_quantity;
    }

    public Integer getProd_item_cost() {
        return prod_item_cost;
    }

    public void setProd_item_cost(Integer prod_item_cost) {
        this.prod_item_cost = prod_item_cost;
    }

    public Date getProd_item_delivered() {
        return prod_item_delivered;
    }

    public void setProd_item_delivered(Date prod_item_delivered) {
        this.prod_item_delivered = prod_item_delivered;
    }

    public Date getProd_item_valid_until() {
        return prod_item_valid_until;
    }

    public void setProd_item_valid_until(Date prod_item_valid_until) {
        this.prod_item_valid_until = prod_item_valid_until;
    }
}
