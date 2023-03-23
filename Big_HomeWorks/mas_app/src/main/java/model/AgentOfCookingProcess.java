package model;

import java.util.ArrayList;
import java.util.List;

public class AgentOfCookingProcess {
    private List<Process> process_log;

    public AgentOfCookingProcess(List<Process> processLog) {
        process_log = new ArrayList<>(processLog);
    }

    public AgentOfCookingProcess() {
    }

    public List<Process> getProcess_log() {
        return new ArrayList<>(process_log);
    }

    public void setProcess_log(List<Process> process_log) {
        this.process_log = new ArrayList<>(process_log);
    }
}
