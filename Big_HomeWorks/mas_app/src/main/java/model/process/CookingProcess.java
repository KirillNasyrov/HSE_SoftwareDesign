package model.process;

import java.util.ArrayList;
import java.util.List;

public class CookingProcess {
    private Integer proc_id;
    private Integer ord_dish;
    private String proc_started;
    private String proc_ended;
    private boolean proc_active;
    private List<ProcessOperation> proc_operations;

    public CookingProcess(Integer procId, Integer ordDish, String procStarted, String procEnded, boolean procActive, List<ProcessOperation> procOperations) {
        proc_id = procId;
        ord_dish = ordDish;
        proc_started = procStarted;
        proc_ended = procEnded;
        proc_active = procActive;
        proc_operations = new ArrayList<>(procOperations);
    }

    public CookingProcess() {
    }

    public Integer getProc_id() {
        return proc_id;
    }

    public void setProc_id(Integer proc_id) {
        this.proc_id = proc_id;
    }

    public Integer getOrd_dish() {
        return ord_dish;
    }

    public void setOrd_dish(Integer ord_dish) {
        this.ord_dish = ord_dish;
    }

    public String getProc_started() {
        return proc_started;
    }

    public void setProc_started(String proc_started) {
        this.proc_started = proc_started;
    }

    public String getProc_ended() {
        return proc_ended;
    }

    public void setProc_ended(String proc_ended) {
        this.proc_ended = proc_ended;
    }

    public boolean isProc_active() {
        return proc_active;
    }

    public void setProc_active(boolean proc_active) {
        this.proc_active = proc_active;
    }

    public List<ProcessOperation> getProc_operations() {
        return new ArrayList<>(proc_operations);
    }

    public void setProc_operations(List<ProcessOperation> proc_operations) {
        this.proc_operations = new ArrayList<>(proc_operations);
    }
}
