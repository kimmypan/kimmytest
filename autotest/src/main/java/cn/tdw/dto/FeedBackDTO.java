package cn.tdw.dto;

import java.time.LocalDateTime;

/**
 * Created by wuganqin on 2017/8/14.
 */
public class FeedBackDTO {

    private int feedBackId;
    private String telNo;
    private String telBrand;
    private String telModel;
    private String osVersion;
    private String appVersion;
    private String content;
    private int status;
    private LocalDateTime createDate;

    public int getFeedBackId() {
        return feedBackId;
    }

    public void setFeedBackId(int feedBackId) {
        this.feedBackId = feedBackId;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public String getTelBrand() {
        return telBrand;
    }

    public void setTelBrand(String telBrand) {
        this.telBrand = telBrand;
    }

    public String getTelModel() {
        return telModel;
    }

    public void setTelModel(String telModel) {
        this.telModel = telModel;
    }

    public String getOsVersion() {
        return osVersion;
    }

    public void setOsVersion(String osVersion) {
        this.osVersion = osVersion;
    }

    public String getAppVersion() {
        return appVersion;
    }

    public void setAppVersion(String appVersion) {
        this.appVersion = appVersion;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "FeedBackDTO{" +
                "feedBackId=" + feedBackId +
                ", telNo='" + telNo + '\'' +
                ", telBrand='" + telBrand + '\'' +
                ", telModel='" + telModel + '\'' +
                ", osVersion='" + osVersion + '\'' +
                ", appVersion='" + appVersion + '\'' +
                ", content='" + content + '\'' +
                ", status=" + status +
                ", createDate=" + createDate +
                '}';
    }
}
