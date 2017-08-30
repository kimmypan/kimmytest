package cn.tdw.domain;

import java.time.LocalDateTime;

/**
 * Created by wuganqin on 2017/8/16.
 */
public class DailyTaskInfo {
    private  int id;
    private int trackerId ;
    private int dayTaskCount;
    private double dayTaskAmount;
    private int dayRepayCount;
    private String dayRepayCountPercent;
    private double dayRepayAmount;
    private String dayRepayAmountPercent;
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

    public int getDayTaskCount() {
        return dayTaskCount;
    }

    public void setDayTaskCount(int dayTaskCount) {
        this.dayTaskCount = dayTaskCount;
    }

    public double getDayTaskAmount() {
        return dayTaskAmount;
    }

    public void setDayTaskAmount(double dayTaskAmount) {
        this.dayTaskAmount = dayTaskAmount;
    }

    public int getDayRepayCount() {
        return dayRepayCount;
    }

    public void setDayRepayCount(int dayRepayCount) {
        this.dayRepayCount = dayRepayCount;
    }

    public String getDayRepayCountPercent() {
        return dayRepayCountPercent;
    }

    public void setDayRepayCountPercent(String dayRepayCountPercent) {
        this.dayRepayCountPercent = dayRepayCountPercent;
    }

    public double getDayRepayAmount() {
        return dayRepayAmount;
    }

    public void setDayRepayAmount(double dayRepayAmount) {
        this.dayRepayAmount = dayRepayAmount;
    }

    public String getDayRepayAmountPercent() {
        return dayRepayAmountPercent;
    }

    public void setDayRepayAmountPercent(String dayRepayAmountPercent) {
        this.dayRepayAmountPercent = dayRepayAmountPercent;
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
