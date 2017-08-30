package cn.tdw.dto;


import cn.tdw.common.utils.excel.annotation.ExcelField;

/**
 * 分配详情DTO
 * Created by wuganqin on 2017/8/15.
 */
public class AllocationDetailDTO {


    private int trackerId;
    @ExcelField(title = "跟踪人员姓名", align = 2, sort = 10)
    private String userName;
    @ExcelField(title = "工号", align = 2, sort = 10)
    private String jobNum;
    @ExcelField(title = "手机号码", align = 2, sort = 10)
    private String mobile;
    /**
     * 今日已分配
     */
    @ExcelField(title = "今日已分配", align = 2, sort = 10)
    private int dayTaskCount;
    /**
     * 今日全额数量
     */
    private int dayRepayCount;
    /**
     * 部分回款数量
     */

    private int dayPortionRepayCount;
    @ExcelField(title = "今日全额/部分回款数量", align = 2, sort = 10)
    private int dayPortionRepayCountMerge;
    /**
     * 今日回款金额
     */
    @ExcelField(title = "今日回款金额", align = 2, sort = 10)
    private double dayRepayAmount;
    /**
     * 本月全额回款数量
     */
    private int monthRepayCount;
    /**
     * 本月部分回款数量
     */

    private int monthPortionRepayCount;
    @ExcelField(title = "本月全额/部分回款数量", align = 2, sort = 10)
    private String monthPortionRepayCountMerge;

    /**
     * 本月回收率(数量)
     */
    @ExcelField(title = "本月回收率(数量)", align = 2, sort = 10)
    private String monthRepayCountPercent;
    /**
     * 本月回款金额
     */
    @ExcelField(title = "本月回款金额", align = 2, sort = 10)
    private double monthRepayAmount;
    /**
     * 本月回收率（金额）
     */
    @ExcelField(title = "本月回收率（金额）", align = 2, sort = 10)
    private String monthRepayAmountPercent;

    /**
     *  待回款数量
     */
    private int taskCount;

    /**
     *  待回款金额
     */
    private double taskAmount;
    @ExcelField(title = "待回款数量/金额", align = 2, sort = 10)
    private String taskAmounMerge;

    public String getTaskAmounMerge() {
        return this.taskCount+"/"+this.taskCount;
    }

    public String  getDayPortionRepayCountMerge() {
        return this.dayRepayCount+"/"+this.dayPortionRepayCount;
    }

    public String getMonthPortionRepayCountMerge() {
        return this.monthRepayCount +"/"+this.monthPortionRepayCount;
    }
    public int getTrackerId() {
        return trackerId;
    }

    public void setTrackerId(int trackerId) {
        this.trackerId = trackerId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getJobNum() {
        return jobNum;
    }

    public void setJobNum(String jobNum) {
        this.jobNum = jobNum;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public String getMonthRepayCountPercent() {
        return monthRepayCountPercent;
    }

    public void setMonthRepayCountPercent(String monthRepayCountPercent) {
        this.monthRepayCountPercent = monthRepayCountPercent;
    }

    public double getMonthRepayAmount() {
        return monthRepayAmount;
    }

    public void setMonthRepayAmount(double monthRepayAmount) {
        this.monthRepayAmount = monthRepayAmount;
    }

    public String getMonthRepayAmountPercent() {
        return monthRepayAmountPercent;
    }

    public void setMonthRepayAmountPercent(String monthRepayAmountPercent) {
        this.monthRepayAmountPercent = monthRepayAmountPercent;
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
