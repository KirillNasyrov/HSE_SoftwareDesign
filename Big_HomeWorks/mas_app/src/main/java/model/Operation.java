package model;

public class Operation {
    private Integer oper_id;
    private Integer oper_proc;
    private Integer oper_card;
    private String oper_started;
    private String oper_ended;
    private Integer oper_coocker_id;
    private boolean oper_active;

    public Operation(Integer operId, Integer operProc, Integer operCard, String operStarted, String operEnded, Integer operCoockerId, boolean operActive) {
        oper_id = operId;
        oper_proc = operProc;
        oper_card = operCard;
        oper_started = operStarted;
        oper_ended = operEnded;
        oper_coocker_id = operCoockerId;
        oper_active = operActive;
    }

    public Operation() {
    }

    public Integer getOper_id() {
        return oper_id;
    }

    public void setOper_id(Integer oper_id) {
        this.oper_id = oper_id;
    }

    public Integer getOper_proc() {
        return oper_proc;
    }

    public void setOper_proc(Integer oper_proc) {
        this.oper_proc = oper_proc;
    }

    public Integer getOper_card() {
        return oper_card;
    }

    public void setOper_card(Integer oper_card) {
        this.oper_card = oper_card;
    }

    public String getOper_started() {
        return oper_started;
    }

    public void setOper_started(String oper_started) {
        this.oper_started = oper_started;
    }

    public String getOper_ended() {
        return oper_ended;
    }

    public void setOper_ended(String oper_ended) {
        this.oper_ended = oper_ended;
    }

    public Integer getOper_coocker_id() {
        return oper_coocker_id;
    }

    public void setOper_coocker_id(Integer oper_coocker_id) {
        this.oper_coocker_id = oper_coocker_id;
    }

    public boolean isOper_active() {
        return oper_active;
    }

    public void setOper_active(boolean oper_active) {
        this.oper_active = oper_active;
    }
}
