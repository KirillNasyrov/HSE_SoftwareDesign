package model.agents;

import model.process.CookingProcess;

import java.util.ArrayList;
import java.util.List;

public class AgentOfCookingProcess {
    private List<CookingProcess> cookingProcess_log;

    public AgentOfCookingProcess(List<CookingProcess> cookingProcessLog) {
        cookingProcess_log = new ArrayList<>(cookingProcessLog);
    }

    public AgentOfCookingProcess() {
    }

    public List<CookingProcess> getProcess_log() {
        return new ArrayList<>(cookingProcess_log);
    }

    public void setProcess_log(List<CookingProcess> cookingProcess_log) {
        this.cookingProcess_log = new ArrayList<>(cookingProcess_log);
    }
}
