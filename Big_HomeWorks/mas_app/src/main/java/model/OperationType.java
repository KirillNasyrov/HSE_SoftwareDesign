package model;

public class OperationType {
    private Integer oper_type_id;
    private String oper_type_name;

    public OperationType(Integer operTypeId, String operTypeName) {
        oper_type_id = operTypeId;
        oper_type_name = operTypeName;
    }

    public OperationType() {
    }

    public Integer getOper_type_id() {
        return oper_type_id;
    }

    public void setOper_type_id(Integer oper_type_id) {
        this.oper_type_id = oper_type_id;
    }

    public String getOper_type_name() {
        return oper_type_name;
    }

    public void setOper_type_name(String oper_type_name) {
        this.oper_type_name = oper_type_name;
    }
}
