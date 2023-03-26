package goodman_screbber.model.operationType;

import java.util.ArrayList;
import java.util.List;

public class DirectoryOfOperationTypes {
    private List<OperationType> operation_types;

    public DirectoryOfOperationTypes(List<OperationType> operationTypes) {
        operation_types = new ArrayList<>(operationTypes);
    }

    public DirectoryOfOperationTypes() {
    }

    public List<OperationType> getOperation_types() {
        return new ArrayList<>(operation_types);
    }

    public void setOperation_types(List<OperationType> operation_types) {
        this.operation_types = new ArrayList<>(operation_types);
    }
}
