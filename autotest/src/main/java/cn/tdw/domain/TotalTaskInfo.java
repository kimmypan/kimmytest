package cn.tdw.domain;

import java.time.LocalDateTime;

/**
 * Created by wuganqin on 2017/8/16.
 */
public class TotalTaskInfo {
    private  int id;
    private int trackerId ;
    private int taskCount;
    private double taskAmount;
    private int repayCount;
    private String repayCountPercent;
    private double repayAmount;
    private String repayAmountPercent;
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

    public String getRepayAmountPercent() {
        return repayAmountPercent;
    }

    public void setRepayAmountPercent(String repayAmountPercent) {
        this.repayAmountPercent = repayAmountPercent;
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
