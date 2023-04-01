package goodman_screbber.model.order.log;


public class OrderDishCardForLog {
    private String nameOfDish;
    private Integer carIdOfDish;

    public OrderDishCardForLog(String nameOfDish, Integer carIdOfDish) {
        this.nameOfDish = nameOfDish;
        this.carIdOfDish = carIdOfDish;
    }

    public OrderDishCardForLog() {
    }

    public String getNameOfDish() {
        return nameOfDish;
    }

    public void setNameOfDish(String nameOfDish) {
        this.nameOfDish = nameOfDish;
    }

    public Integer getCarIdOfDish() {
        return carIdOfDish;
    }

    public void setCarIdOfDish(Integer carIdOfDish) {
        this.carIdOfDish = carIdOfDish;
    }
}
