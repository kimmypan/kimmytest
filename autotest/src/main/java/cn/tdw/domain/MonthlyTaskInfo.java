package cn.tdw.domain;

import java.time.LocalDateTime;

/**
 * Created by wuganqin on 2017/8/16.
 */
public class MonthlyTaskInfo {
    private  int id;
    private int trackerId ;
    private int monthTaskCount;
    private double monthTaskAmount;
    private int monthRepayCount;
    private String monthRepayCountPercent;
    private double monthRepayAmount;
    private String monthRepayAmountPercent;
    private String addDate;
    private String remark;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private int isDeleted;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTrackerId() {
        return trackerId;
    }

    public void setTrackerId(int trackerId) {
        this.trackerId = trackerId;
    }

    public int getMonthTaskCount() {
        return monthTaskCount;
    }

    public void setMonthTaskCount(int monthTaskCount) {
        this.monthTaskCount = monthTaskCount;
    }

    public double getMonthTaskAmount() {
        return monthTaskAmount;
    }

    public void setMonthTaskAmount(double monthTaskAmount) {
        this.monthTaskAmount = monthTaskAmount;
    }

    public int getMonthRepayCount() {
        return monthRepayCount;
    }

    public void setMonthRepayCount(int monthRepayCount) {
        this.monthRepayCount = monthRepayCount;
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

    public String getAddDate() {
        return addDate;
    }

    public void setAddDate(String addDate) {
        this.addDate = addDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public LocalDateTime getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(LocalDateTime updateTime) {
        this.updateTime = updateTime;
    }

    public int getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(int isDeleted) {
        this.isDeleted = isDeleted;
    }
}
