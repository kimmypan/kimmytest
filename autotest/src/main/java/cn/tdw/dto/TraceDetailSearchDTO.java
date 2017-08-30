package cn.tdw.dto;

/**
 * Created by wuganqin on 2017/8/17.
 */
public class TraceDetailSearchDTO {
    private Integer page = 1;
    private Integer limit = 10;
    private String realName;
    private Integer repayStatus;
    private String repayBDate;
    private String repayEDate;
    private String telNo;
    private Integer overdueMinDay;
    private Integer overdueMaxDay;
    private String allocateSDate;
    private String allocateEDate;
    private String trackerName;
    private Integer repayType;
    private Long trackerId;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getLimit() {
        return limit;
    }

    public void setLimit(Integer limit) {
        this.limit = limit;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public Integer getRepayStatus() {
        return repayStatus;
    }

    public void setRepayStatus(Integer repayStatus) {
        this.repayStatus = repayStatus;
    }

    public String getRepayBDate() {
        return repayBDate;
    }

    public void setRepayBDate(String repayBDate) {
        this.repayBDate = repayBDate;
    }

    public String getRepayEDate() {
        return repayEDate;
    }

    public void setRepayEDate(String repayEDate) {
        this.repayEDate = repayEDate;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public Integer getOverdueMinDay() {
        return overdueMinDay;
    }

    public void setOverdueMinDay(Integer overdueMinDay) {
        this.overdueMinDay = overdueMinDay;
    }

    public Integer getOverdueMaxDay() {
        return overdueMaxDay;
    }

    public void setOverdueMaxDay(Integer overdueMaxDay) {
        this.overdueMaxDay = overdueMaxDay;
    }

    public String getAllocateSDate() {
        return allocateSDate;
    }

    public void setAllocateSDate(String allocateSDate) {
        this.allocateSDate = allocateSDate;
    }

    public String getAllocateEDate() {
        return allocateEDate;
    }

    public void setAllocateEDate(String allocateEDate) {
        this.allocateEDate = allocateEDate;
    }

    public String getTrackerName() {
        return trackerName;
    }

    public void setTrackerName(String trackerName) {
        this.trackerName = trackerName;
    }

    public Integer getRepayType() {
        return repayType;
    }

    public void setRepayType(Integer repayType) {
        this.repayType = repayType;
    }

    public Long getTrackerId() {
        return trackerId;
    }

    public void setTrackerId(Long trackerId) {
        this.trackerId = trackerId;
    }
}
