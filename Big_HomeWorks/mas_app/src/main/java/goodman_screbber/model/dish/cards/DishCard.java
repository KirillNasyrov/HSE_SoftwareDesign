package goodman_screbber.model.dish.cards;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.ArrayList;
import java.util.List;

public class DishCard {
    @JsonProperty("card_id")
    private Integer cardId;

    @JsonProperty("dish_name")
    private String dishName;

    @JsonProperty("card_descr")
    private String cardDescription;

    @JsonProperty("card_time")
    private Double cardTime;

    @JsonProperty("equip_type")
    private Integer equipmentType;

    private List<DishCardsOperations> operations;

    public DishCard(Integer cardId, String dishName, String cardDescription, Double cardTime, Integer equipmentType,
                    List<DishCardsOperations> operations) {
        this.cardId = cardId;
        this.dishName = dishName;
        this.cardDescription = cardDescription;
        this.cardTime = cardTime;
        this.equipmentType = equipmentType;
        this.operations = new ArrayList<>(operations);
    }

    public DishCard() {
    }

    public Integer getCardId() {
        return cardId;
    }

    public void setCardId(Integer cardId) {
        this.cardId = cardId;
    }

    public String getDishName() {
        return dishName;
    }

    public void setDishName(String dishName) {
        this.dishName = dishName;
    }

    public String getCard_descr() {
        return cardDescription;
    }

    public void setCard_descr(String card_descr) {
        this.cardDescription = card_descr;
    }

    public Double getCardTime() {
        return cardTime;
    }

    public void setCardTime(Double cardTime) {
        this.cardTime = cardTime;
    }

    public Integer getEquipmentType() {
        return equipmentType;
    }

    public void setEquipmentType(Integer equipmentType) {
        this.equipmentType = equipmentType;
    }

    public List<DishCardsOperations> getOperations() {
        return new ArrayList<>(operations);
    }

    public void setOperations(List<DishCardsOperations> operations) {
        this.operations = new ArrayList<>(operations);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DishCard dishCard)) return false;

        if (!cardId.equals(dishCard.cardId)) return false;
        if (!dishName.equals(dishCard.dishName)) return false;
        if (!cardDescription.equals(dishCard.cardDescription)) return false;
        if (!cardTime.equals(dishCard.cardTime)) return false;
        if (!equipmentType.equals(dishCard.equipmentType)) return false;
        return operations.equals(dishCard.operations);
    }

    @Override
    public int hashCode() {
        int result = cardId.hashCode();
        result = 31 * result + dishName.hashCode();
        result = 31 * result + cardDescription.hashCode();
        result = 31 * result + cardTime.hashCode();
        result = 31 * result + equipmentType.hashCode();
        result = 31 * result + operations.hashCode();
        return result;
    }
}
