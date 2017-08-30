package cn.tdw.domain;

import io.swagger.models.auth.In;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 借款记录
 *
 * @Author liubin
 * @Date 2017/8/12 18:00
 */
public class BorrowInfo {

    private String borrowId;

    private String userId;

    private String couponId;

    private String userName;

    private String realName;

    private String telNo;

    private int deadline;

    private String contractNo;

    private Integer status;

    private Long amount;

    private Long realAmount;

    private Long tuandaiAmount;

    private Long messageAmount;

    private Long guaranteAmount;

    private Long interestAmount;

    private Long couponAmount;

    private Boolean isDeleted;

    private Boolean isHandle;

    private LocalDate cycDate;

    private LocalDateTime handleDate;

    private LocalDateTime createDate;

    private LocalDateTime lastUpdated;

    private Integer version;
    /**
     * 公告
     */
    private String announcement;
    /**
     * 团贷费率
     */
    private Integer tuandaiRate;
    /**
     * 信息费率
     */
    private Integer messageRate;
    /**
     * 担保费率
     */
    private Integer guaranteRate;
    /**
     * 借款利率
     */
    private Double lendingrate;

    /**
     * 逾期天数
     */
    private Long day;
    /**
     * 罚息(滞纳金)
     */
    private Integer penaltyAmount;

    /**
     * 应还金额
     */
    private Long alsoAmount;
    /**
     * 服务费
     */
    private Long servicecharge;

    /**
     * 实际还款金额
     */
    private Long actualamount;

    /**
     * 应还金额
     */
    private Integer cost;

    /**
     * 来源
     */
    private String channelName;

    /**
     * 实际还款时间
     */
    private LocalDate realityDate;

    public String getAnnouncement() {
        return announcement;
    }

    public void setAnnouncement(String announcement) {
        this.announcement = announcement;
    }

    public LocalDate getRealityDate() {
        return realityDate;
    }

    public void setRealityDate(LocalDate realityDate) {
        this.realityDate = realityDate;
    }

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public Integer getTuandaiRate() {
        return tuandaiRate;
    }

    public void setTuandaiRate(Integer tuandaiRate) {
        this.tuandaiRate = tuandaiRate;
    }

    public Integer getMessageRate() {
        return messageRate;
    }

    public void setMessageRate(Integer messageRate) {
        this.messageRate = messageRate;
    }

    public Integer getGuaranteRate() {
        return guaranteRate;
    }

    public void setGuaranteRate(Integer guaranteRate) {
        this.guaranteRate = guaranteRate;
    }

    public Long getDay() {
        return day;
    }

    public Integer getPenaltyAmount() {
        return penaltyAmount;
    }

    public void setPenaltyAmount(Integer penaltyAmount) {
        this.penaltyAmount = penaltyAmount;
    }

    public Integer getCost() {
        return cost;
    }

    public void setCost(Integer cost) {
        this.cost = cost;
    }


    private Long getAlsoAmount() {
        return alsoAmount;
    }


    public Long getActualamount() {
        return actualamount;
    }

    public void setActualamount(Long actualamount) {
        this.actualamount = actualamount;
    }

    public Long getServicecharge() {
        return servicecharge;
    }

    public void setServicecharge(Long servicecharge) {
        this.servicecharge = servicecharge;
    }

    public void setAlsoAmount(Long alsoAmount) {
        this.alsoAmount = alsoAmount;
    }

    public Double getLendingrate() {
        return lendingrate;
    }

    public void setLendingrate(Double lendingrate) {
        this.lendingrate = lendingrate;
    }

    public Long getDay(long day) {
        return this.day;
    }

    public void setDay(Long day) {
        this.day = day;
    }

    public Integer getPenaltyrate() {
        return penaltyAmount;
    }

    public void setPenaltyrate(Integer penaltyrate) {
        this.penaltyAmount = penaltyrate;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
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

    public String getCouponId() {
        return couponId;
    }

    public void setCouponId(String couponId) {
        this.couponId = couponId;
    }

    public int getDeadline() {
        return deadline;
    }

    public void setDeadline(int deadline) {
        this.deadline = deadline;
    }

    public String getContractNo() {
        return contractNo;
    }

    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
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

    public Long getRealAmount() {
        return realAmount;
    }

    public void setRealAmount(Long realAmount) {
        this.realAmount = realAmount;
    }

    public Long getTuandaiAmount() {
        return tuandaiAmount;
    }

    public void setTuandaiAmount(Long tuandaiAmount) {
        this.tuandaiAmount = tuandaiAmount;
    }

    public Long getMessageAmount() {
        return messageAmount;
    }

    public void setMessageAmount(Long messageAmount) {
        this.messageAmount = messageAmount;
    }

    public Long getGuaranteAmount() {
        return guaranteAmount;
    }

    public void setGuaranteAmount(Long guaranteAmount) {
        this.guaranteAmount = guaranteAmount;
    }

    public Long getInterestAmount() {
        return interestAmount;
    }

    public void setInterestAmount(Long interestAmount) {
        this.interestAmount = interestAmount;
    }

    public Long getCouponAmount() {
        return couponAmount;
    }

    public void setCouponAmount(Long couponAmount) {
        this.couponAmount = couponAmount;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Boolean getHandle() {
        return isHandle;
    }

    public void setHandle(Boolean handle) {
        isHandle = handle;
    }

    public LocalDate getCycDate() {
        return cycDate;
    }

    public void setCycDate(LocalDate cycDate) {
        this.cycDate = cycDate;
    }

    public LocalDateTime getHandleDate() {
        return handleDate;
    }

    public void setHandleDate(LocalDateTime handleDate) {
        this.handleDate = handleDate;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

}
