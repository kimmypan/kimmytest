package cn.tdw.dto;

import java.text.DecimalFormat;

/**
 * Created by wuganqin on 2017/8/15.
 */
public class StatisticsTaskDTO {

    private long trackerId;
    private double taskAmount;
    private int taskCount;
    private int repayCount;
    private double repayAmount;
    private String addDate;

    public String getRepayCountPercent() {
        DecimalFormat df = new DecimalFormat("0.00%");
        return df.format((float) this.repayCount/taskCount);
    }


    public String getRepayAmountPercent() {
        DecimalFormat df = new DecimalFormat("0.00%");
        return df.format(this.repayAmount/this.taskAmount);
    }





    public long getTrackerId() {
        return trackerId;
    }

    public void setTrackerId(long trackerId) {
        this.trackerId = trackerId;
    }

    public double getTaskAmount() {
        return taskAmount;
    }

    public void setTaskAmount(double taskAmount) {
        this.taskAmount = taskAmount;
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

    public double getRepayAmount() {
        return repayAmount;
    }

    public void setRepayAmount(double repayAmount) {
        this.repayAmount = repayAmount;
    }



    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate;
    }




}
