package cn.tdw.dto;


/**
 * 分配详情DTO
 * Created by wuganqin on 2017/8/15.
 */
public class AllocationDetailTotalDTO {
    private int trackerCount;

    /**
     * 今日已分配
     */
    private int dayTaskCount;
    /**
     * 今日全额数量
     */
    private int dayRepayCount;
    /**
     * 部分回款数量
     */
    private int dayPortionRepayCount;
    /**
     * 今日回款金额
     */
    private double dayRepayAmount;
    /**
     * 本月全额回款数量
     */
    private int monthRepayCount;
    /**
     * 本月部分回款数量
     */
    private int monthPortionRepayCount;

    /**
     * 本月回款金额
     */
    private double monthRepayAmount;

    /**
     *  待回款数量
     */
    private int taskCount;

    /**
     *  待回款金额
     */
    private double taskAmount;


    public int getTrackerCount() {
        return trackerCount;
    }

    public void setTrackerCount(int trackerCount) {
        this.trackerCount = trackerCount;
    }

    public int getDayTaskCount() {
        return dayTaskCount;
    }

    public void setDayTaskCount(int dayTaskCount) {
        this.dayTaskCount = dayTaskCount;
    }

    public int getDayRepayCount() {
        return dayRepayCount;
    }

    public void setDayRepayCount(int dayRepayCount) {
        this.dayRepayCount = dayRepayCount;
    }

    public int getDayPortionRepayCount() {
        return dayPortionRepayCount;
    }

    public void setDayPortionRepayCount(int dayPortionRepayCount) {
        this.dayPortionRepayCount = dayPortionRepayCount;
    }

    public double getDayRepayAmount() {
        return dayRepayAmount;
    }

    public void setDayRepayAmount(double dayRepayAmount) {
        this.dayRepayAmount = dayRepayAmount;
    }

    public int getMonthRepayCount() {
        return monthRepayCount;
    }

    public void setMonthRepayCount(int monthRepayCount) {
        this.monthRepayCount = monthRepayCount;
    }

    public int getMonthPortionRepayCount() {
        return monthPortionRepayCount;
    }

    public void setMonthPortionRepayCount(int monthPortionRepayCount) {
        this.monthPortionRepayCount = monthPortionRepayCount;
    }

    public double getMonthRepayAmount() {
        return monthRepayAmount;
    }

    public void setMonthRepayAmount(double monthRepayAmount) {
        this.monthRepayAmount = monthRepayAmount;
    }

    public int getTaskCount() {
        return taskCount;
    }

    public void setTaskCount(int taskCount) {
        this.taskCount = taskCount;
    }

    public double getTaskAmount() {
        return taskAmount;
    }

    public void setTaskAmount(double taskAmount) {
        this.taskAmount = taskAmount;
    }
}
