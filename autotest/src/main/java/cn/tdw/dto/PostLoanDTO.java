package cn.tdw.dto;

import cn.tdw.common.constants.BorrowInfoStatusEnum;
import org.springframework.data.annotation.Transient;

import java.time.LocalDate;

/**
 * 贷后管理
 * Created by huangwenchang on 2017/8/14.
 */
public class PostLoanDTO {

    private String borrowId;    //借款记录id
    private Integer status;     //状态
    private long amount;        //合同金额
    private long realAmount;    //到手金额
    private Long channelId;     //渠道商编号
    private String channelName; //渠道商名称
    private String userId;      //客户id
    private String realName;    //客户姓名
    private String telNo;

    //逾期应还款金额 cost + penaltyAmount
    private long cost;
    private long penaltyAmount;

    private String overDueId;   //逾期记录id
    private String trackerName; //跟踪人姓名
    private Long trackerId;     //跟踪人id
    private LocalDate cycDate;  //还款日期
    private int overDueDays;    //逾期天数

    @Transient
    private String statusText;

    public String getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(String borrowId) {
        this.borrowId = borrowId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public long getRealAmount() {
        return realAmount;
    }

    public void setRealAmount(long realAmount) {
        this.realAmount = realAmount;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
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

    public long getCost() {
        return cost;
    }

    public void setCost(long cost) {
        this.cost = cost;
    }

    public long getPenaltyAmount() {
        return penaltyAmount;
    }

    public void setPenaltyAmount(long penaltyAmount) {
        this.penaltyAmount = penaltyAmount;
    }

    public String getOverDueId() {
        return overDueId;
    }

    public void setOverDueId(String overDueId) {
        this.overDueId = overDueId;
    }

    public String getTrackerName() {
        return trackerName;

    }

    public void setTrackerName(String trackerName) {
        this.trackerName = trackerName;
    }

    public Long getTrackerId() {
        return trackerId;
    }

    public void setTrackerId(Long trackerId) {
        this.trackerId = trackerId;
    }

    public LocalDate getCycDate() {
        return cycDate;
    }

    public void setCycDate(LocalDate cycDate) {
        this.cycDate = cycDate;
    }

    public int getOverDueDays() {
        return overDueDays;
    }

    public void setOverDueDays(int overDueDays) {
        this.overDueDays = overDueDays;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getStatusText() {
        if (this.status == null) {
            return "";
        }
        return BorrowInfoStatusEnum.getValueByKey(this.status);
    }
}
