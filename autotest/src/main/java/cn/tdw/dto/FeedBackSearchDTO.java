package cn.tdw.dto;

/**
 * Created by wuganqin on 2017/8/14.
 */
public class FeedBackSearchDTO {

    private int page = 1;
    private int limit = 20;
    private String startDate;
    private String endDate;


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

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }
}
