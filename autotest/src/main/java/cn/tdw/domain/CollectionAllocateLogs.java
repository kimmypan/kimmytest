package cn.tdw.domain;

import java.time.LocalDateTime;

/**
 * 工作分配/移交日志
 * Created by huangwenchang on 2017/8/22.
 */
public class CollectionAllocateLogs {
    private Long id;
    private String borrowId;
    private Long oldTrackerId;
    private Long newTrackerId;
    private String operatorId;
    private Integer operateType;
    private String remark;
    private LocalDateTime createTime;
    private Integer isDeleted;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(String borrowId) {
        this.borrowId = borrowId;
    }

    public Long getOldTrackerId() {
        return oldTrackerId;
    }

    public void setOldTrackerId(Long oldTrackerId) {
        this.oldTrackerId = oldTrackerId;
    }

    public Long getNewTrackerId() {
        return newTrackerId;
    }

    public void setNewTrackerId(Long newTrackerId) {
        this.newTrackerId = newTrackerId;
    }

    public String getOperatorId() {
        return operatorId;
    }

    public void setOperatorId(String operatorId) {
        this.operatorId = operatorId;
    }

    public Integer getOperateType() {
        return operateType;
    }

    public void setOperateType(Integer operateType) {
        this.operateType = operateType;
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

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}
