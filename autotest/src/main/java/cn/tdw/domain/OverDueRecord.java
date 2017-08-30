package cn.tdw.domain;

import java.time.LocalDateTime;

/**
 * Created by huangwenchang on 2017/8/15.
 */
public class OverDueRecord {

    private Long overDueId;
    private String borrowId;
    private Long cost;
    private Long interest;
    private Long penaltyAmount;
    private Long overDueInterest;
    private Long actualCost;
    private Long actualInterest;
    private Integer isBorrow;
    private String borrowUserId;
    private LocalDateTime currentPenaltyHanderDate;
    private LocalDateTime handlerDate;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdated;

    public Long getOverDueId() {
        return overDueId;
    }

    public void setOverDueId(Long overDueId) {
        this.overDueId = overDueId;
    }

    public String getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(String borrowId) {
        this.borrowId = borrowId;
    }

    public Long getCost() {
        return cost;
    }

    public void setCost(Long cost) {
        this.cost = cost;
    }

    public Long getInterest() {
        return interest;
    }

    public void setInterest(Long interest) {
        this.interest = interest;
    }

    public Long getPenaltyAmount() {
        return penaltyAmount;
    }

    public void setPenaltyAmount(Long penaltyAmount) {
        this.penaltyAmount = penaltyAmount;
    }

    public Long getOverDueInterest() {
        return overDueInterest;
    }

    public void setOverDueInterest(Long overDueInterest) {
        this.overDueInterest = overDueInterest;
    }

    public Long getActualCost() {
        return actualCost;
    }

    public void setActualCost(Long actualCost) {
        this.actualCost = actualCost;
    }

    public Long getActualInterest() {
        return actualInterest;
    }

    public void setActualInterest(Long actualInterest) {
        this.actualInterest = actualInterest;
    }

    public Integer getIsBorrow() {
        return isBorrow;
    }

    public void setIsBorrow(Integer isBorrow) {
        this.isBorrow = isBorrow;
    }

    public String getBorrowUserId() {
        return borrowUserId;
    }

    public void setBorrowUserId(String borrowUserId) {
        this.borrowUserId = borrowUserId;
    }

    public LocalDateTime getCurrentPenaltyHanderDate() {
        return currentPenaltyHanderDate;
    }

    public void setCurrentPenaltyHanderDate(LocalDateTime currentPenaltyHanderDate) {
        this.currentPenaltyHanderDate = currentPenaltyHanderDate;
    }

    public LocalDateTime getHandlerDate() {
        return handlerDate;
    }

    public void setHandlerDate(LocalDateTime handlerDate) {
        this.handlerDate = handlerDate;
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
}
