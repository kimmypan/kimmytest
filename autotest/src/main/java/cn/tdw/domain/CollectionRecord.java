package cn.tdw.domain;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 催收记录
 * Created by huanzghenwei on 2017/8/14.
 */
public class CollectionRecord {
    /**
     * 借款记录
     */
    private String borrowId;
    /**
     * 是否已发送短信
     */
    private Integer isSend;
    /**
     * 发送日期
     */
    private Timestamp sendDate;
    /**
     * 操作人
     */
    private String operatorId;
    /**
     * 操作类型
     */
    private Integer operateType;
    /**
     * 催收情况
     */
    private String collectionInfo;
    /**
     * 备注
     */
    private String remark;
    /**
     * 新增时间
     */
    private LocalDateTime createTime;
    /**
     * 删除时间
     */
    private LocalDateTime isDeleted;

    /**
     * 年月日时间
     */
    private LocalDate createDate;

    public LocalDate getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDate createDate) {
        this.createDate = createDate;
    }

    public String getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(String borrowId) {
        this.borrowId = borrowId;
    }

    public Integer getIsSend() {
        return isSend;
    }

    public void setIsSend(Integer isSend) {
        this.isSend = isSend;
    }

    public Timestamp getSendDate() {
        return sendDate;
    }

    public void setSendDate(Timestamp sendDate) {
        this.sendDate = sendDate;
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

    public String getCollectionInfo() {
        return collectionInfo;
    }

    public void setCollectionInfo(String collectionInfo) {
        this.collectionInfo = collectionInfo;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public LocalDateTime getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(LocalDateTime isDeleted) {
        this.isDeleted = isDeleted;
    }

}

