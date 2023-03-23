package model;

import java.util.ArrayList;
import java.util.List;

public class AgentOfOperation {
    private List<Operation> operation_log;

    public AgentOfOperation(List<Operation> operationLog) {
        operation_log = new ArrayList<>(operationLog);
    }

    public AgentOfOperation() {
    }

    public List<Operation> getOperation_log() {
        return new ArrayList<>(operation_log);
    }

    public void setOperation_log(List<Operation> operation_log) {
        this.operation_log = new ArrayList<>(operation_log);
    }
}
