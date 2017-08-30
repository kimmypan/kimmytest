package cn.tdw.dto;

/**
 * Created by wuganqin on 2017/8/17.
 */
public class TraceDetailTotalDTO {

    private  int trackerCount;
    private  int taskCount;
    private  int repayCount;
    private  String repayCountPercent;
    private  double repayAmount;
    private  int repayAmountPercent;

    public int getTrackerCount() {
        return trackerCount;
    }

    public void setTrackerCount(int trackerCount) {
        this.trackerCount = trackerCount;
    }

    public int getTaskCount() {
        return taskCount;
    }

    public void setTaskCount(int taskCount) {
        this.taskCount = taskCount;
    }

    public int getRepayCount() {
        return repayCount;
    }

    public void setRepayCount(int repayCount) {
        this.repayCount = repayCount;
    }

    public String getRepayCountPercent() {
        return repayCountPercent;
    }

    public void setRepayCountPercent(String repayCountPercent) {
        this.repayCountPercent = repayCountPercent;
    }

    public double getRepayAmount() {
        return repayAmount;
    }

    public void setRepayAmount(double repayAmount) {
        this.repayAmount = repayAmount;
    }

    public int getRepayAmountPercent() {
        return repayAmountPercent;
    }

    public void setRepayAmountPercent(int repayAmountPercent) {
        this.repayAmountPercent = repayAmountPercent;
    }
}
