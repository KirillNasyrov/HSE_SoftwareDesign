package goodman_screbber.model.dish.cards;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class DishCardsOperations {

    @JsonProperty("oper_type")
    private Integer operationType;

    @JsonProperty("equip_type")
    private Integer equipmentType;

    @JsonProperty("oper_time")
    private Double operationTime;

    @JsonProperty("oper_async_point")
    private Integer operationAsyncPoint;

    @JsonProperty("oper_products")
    private List<DishCardsOperationsProducts> operationProducts;

    public DishCardsOperations(Integer operationType, Integer equipmentType, Double operationTime, Integer operationAsyncPoint, List<DishCardsOperationsProducts> operationProducts) {
        this.operationType = operationType;
        this.equipmentType = equipmentType;
        this.operationTime = operationTime;
        this.operationAsyncPoint = operationAsyncPoint;
        this.operationProducts = operationProducts;
    }

    public DishCardsOperations() {
    }

    public Integer getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(Integer equipmentType) {
        this.equipmentType = equipmentType;
    }

    public Integer getOperationType() {
        return operationType;
    }

    public void setOperationType(Integer operationType) {
        this.operationType = operationType;
    }

    public Double getOperationTime() {
        return operationTime;
    }

    public void setOperationTime(Double operationTime) {
        this.operationTime = operationTime;
    }

    public Integer getOperationAsyncPoint() {
        return operationAsyncPoint;
    }

    public void setOperationAsyncPoint(Integer operationAsyncPoint) {
        this.operationAsyncPoint = operationAsyncPoint;
    }

    public List<DishCardsOperationsProducts> getOperationProducts() {
        return new ArrayList<>(operationProducts);
    }

    public void setOperationProducts(List<DishCardsOperationsProducts> operationProducts) {
        this.operationProducts = new ArrayList<>(operationProducts);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DishCardsOperations that)) return false;

        if (!operationType.equals(that.operationType)) return false;
        if (!equipmentType.equals(that.equipmentType)) return false;
        if (!operationTime.equals(that.operationTime)) return false;
        if (!operationAsyncPoint.equals(that.operationAsyncPoint)) return false;
        return operationProducts.equals(that.operationProducts);
    }

    @Override
    public int hashCode() {
        int result = operationType.hashCode();
        result = 31 * result + equipmentType.hashCode();
        result = 31 * result + operationTime.hashCode();
        result = 31 * result + operationAsyncPoint.hashCode();
        result = 31 * result + operationProducts.hashCode();
        return result;
    }
}
