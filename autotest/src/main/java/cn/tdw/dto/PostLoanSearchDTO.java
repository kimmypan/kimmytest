package cn.tdw.dto;

import java.time.LocalDate;

/**
 * 贷后管理
 * Created by huangwenchang on 2017/8/14.
 */
public class PostLoanSearchDTO {

    private String realName;
    private String telNo;
    private String cycDateBegin;
    private String CycDateEnd;
    private Integer status;
    private String borrowId;
    private Long channelId;
    private Integer overDueDaysBegin;
    private Integer overDueDaysEnd;
    private String trackerName;
    private Long trackerId;
    private LocalDate today;

    private int page = 1;
    private int limit = 20;

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

    public String getCycDateBegin() {
        return cycDateBegin;
    }

    public void setCycDateBegin(String cycDateBegin) {
        this.cycDateBegin = cycDateBegin;
    }

    public String getCycDateEnd() {
        return CycDateEnd;
    }

    public void setCycDateEnd(String cycDateEnd) {
        CycDateEnd = cycDateEnd;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(String borrowId) {
        this.borrowId = borrowId;
    }

    public Long getChannelId() {
        return channelId;
    }

    public void setChannelId(Long channelId) {
        this.channelId = channelId;
    }

    public String getTrackerName() {
        return trackerName;
    }

    public void setTrackerName(String trackerName) {
        this.trackerName = trackerName;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public Long getTrackerId() {
        return trackerId;
    }

    public void setTrackerId(Long trackerId) {
        this.trackerId = trackerId;
    }

    public LocalDate getToday() {
        return today;
    }

    public void setToday(LocalDate today) {
        this.today = today;
    }

    public Integer getOverDueDaysBegin() {
        return overDueDaysBegin;
    }

    public void setOverDueDaysBegin(Integer overDueDaysBegin) {
        this.overDueDaysBegin = overDueDaysBegin;
    }

    public Integer getOverDueDaysEnd() {
        return overDueDaysEnd;
    }

    public void setOverDueDaysEnd(Integer overDueDaysEnd) {
        this.overDueDaysEnd = overDueDaysEnd;
    }
}
