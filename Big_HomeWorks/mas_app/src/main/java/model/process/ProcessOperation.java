package model.process;

public class ProcessOperation {
    private Integer proc_oper;

    public ProcessOperation(Integer procOper) {
        proc_oper = procOper;
    }

    public ProcessOperation() {
    }

    public Integer getProc_oper() {
        return proc_oper;
    }

    public void setProc_oper(Integer proc_oper) {
        this.proc_oper = proc_oper;
    }
}
