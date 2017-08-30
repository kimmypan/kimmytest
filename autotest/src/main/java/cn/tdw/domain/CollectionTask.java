package cn.tdw.domain;

import java.time.LocalDateTime;

/**
 * 催收任务分配
 * Created by huangwenchang on 2017/8/18.
 */
public class CollectionTask {

    private Long id;
    private String borrowId;    //借款记录id
    private Long trackerId;     //跟踪人id (sys_user.user_id)
    private String remark;      //备注
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
    private Integer isDeleted;  //删除标志

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

    public Long getTrackerId() {
        return trackerId;
    }

    public void setTrackerId(Long trackerId) {
        this.trackerId = trackerId;
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

    public Integer getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(Integer isDeleted) {
        this.isDeleted = isDeleted;
    }
}
