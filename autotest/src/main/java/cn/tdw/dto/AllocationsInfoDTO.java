package cn.tdw.dto;

import cn.tdw.common.constants.BorrowInfoStatusEnum;
import org.springframework.data.annotation.Transient;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 电话催收分配
 * Created by yaodingguo on 2017/8/15.
 */
public class AllocationsInfoDTO {
    private String borrowId;//借款记录id
    private String userId;//借款人id
    private String userName;//用户名
    private String realName;//借款人真实姓名
    private String telNo;//手机号码
    private Integer status;//借款状态
    private Long amount;//借款金额
    private Long penaltyAmount;//滞纳金
    private Long cost;
    private LocalDate cycDate;//还款日期
    private Long trackerId;//跟踪人id
    private String trackerName;//跟踪人姓名
    private LocalDateTime createTime;//分配时间
    private String overdueDays;//逾期天数
    @Transient
    private String statusText;//还款状态字符类型
    @Transient
    private Long repayAmount;//还款金额

    public Long getTrackerId() {
        return trackerId;
    }

    public void setTrackerId(Long trackerId) {
        this.trackerId = trackerId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getTrackerName() {
        return trackerName;
    }

    public void setTrackerName(String trackerName) {
        this.trackerName = trackerName;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getStatusText() {
        if (this.status != null){
            return BorrowInfoStatusEnum.getValueByKey(this.status);
        }
        return "";
    }

    public String getOverdueDays() {
        return overdueDays;
    }

    public String getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(String borrowId) {
        this.borrowId = borrowId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }

    public LocalDate getCycDate() {
        return cycDate;
    }

    public void setCycDate(LocalDate cycDate) {
        this.cycDate = cycDate;
    }

    public Long getPenaltyAmount() {
        return penaltyAmount;
    }

    public void setPenaltyAmount(Long penaltyAmount) {
        this.penaltyAmount = penaltyAmount;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    /**
     * 逾期应还金额
     * @return
     */
    public Long getRepayAmount() {
        long result = 0;
        if (this.cost != null){
            result = result + this.cost;
        }
        if (this.penaltyAmount != null) {
            result = result + this.penaltyAmount;
        }
        return result;
    }
}
