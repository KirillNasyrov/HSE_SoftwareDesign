package goodman_screbber.model.order.log;

public class NotFoundDishCardErrorForLog {
    private String error = "No card of such dish from menu";

    private Integer menuID;

    public NotFoundDishCardErrorForLog(Integer menuID) {
        this.menuID = menuID;
    }

    public NotFoundDishCardErrorForLog() {
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Integer getMenuID() {
        return menuID;
    }

    public void setMenuID(Integer menuID) {
        this.menuID = menuID;
    }
}
