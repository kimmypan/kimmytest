package cn.tdw.dto;

/**
 * 可分配/移交人员列表DTO
 * Created by yaodingguo on 2017/8/17.
 */
public class TrackersInfoDTO {
    private Long userId;
    private String userName;//用户名
    private String nickName;//姓名
    private String jobNum;//工号
    private Integer allocateToday;//今日已分配
    private Integer noReslove;//待处理

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getJobNum() {
        return jobNum;
    }

    public void setJobNum(String jobNum) {
        this.jobNum = jobNum;
    }

    public Integer getAllocateToday() {
        return allocateToday;
    }

    public void setAllocateToday(Integer allocateToday) {
        this.allocateToday = allocateToday;
    }

    public Integer getNoReslove() {
        return noReslove;
    }

    public void setNoReslove(Integer noReslove) {
        this.noReslove = noReslove;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }
}
