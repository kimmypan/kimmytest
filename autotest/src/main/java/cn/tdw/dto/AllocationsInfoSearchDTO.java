package cn.tdw.dto;

import java.time.LocalDate;

/**
 * 电话催收分配查询类
 * Created by yaodingguo on 2017/8/15.
 */
public class AllocationsInfoSearchDTO {
    private String userName;//用户姓名
    private Integer repayStatue;//还款状态
    private String repayBDate;//还款开始日期
    private String repayEDate;//还款结束日期
    private String mobile;//手机号码
    private Integer overdueMinDay;//最少逾期天数
    private Integer overdueMaxDay;//最多逾期天数
    private String allocateSDate;//分配开始时间
    private String allocateEDate;//分配结束时间
    private String trackerName;//跟踪人
    private Integer page = 1;//页数
    private Integer limit = 15;//每页条数

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getRepayStatue() {
        return repayStatue;
    }

    public void setRepayStatue(Integer repayStatue) {
        this.repayStatue = repayStatue;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
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

    public String getTrackerName() {
        return trackerName;
    }

    public void setTrackerName(String trackerName) {
        this.trackerName = trackerName;
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
}
