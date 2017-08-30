package cn.tdw.domain;

import org.mockito.cglib.core.Local;

import java.time.LocalDateTime;

/**
 * 查看身份证信息
 * Created by huanzhenwei on 2017/8/17.
 */
public class UserBasicInfoExt {
    /**
     * 用户Id
     */
    private String userId;
    /**
     * 身份证正面
     */
    private String frontCardBucket;
    /**
     * 身份证正面Id
     */
    private String frontCardObjectId;
    /**
     * 身份证背面
     */
    private String backCardBucket;
    /**
     * 身份证背面Id
     */
    private String backCardObjectId;
    /**
     * 活体视频
     */
    private String livenessBucket;
    /**
     * 活体视频Id
     */
    private String livenessObjectId;
    /**
     * 邮箱
     */
    private String email;
    /**
     * 身份证正面地址
     */
    private String frontCardBucket_url;
    /**
     * 身份证背面地址
     */
    private String backCardBucket_url;

    /**
     * 身份证活体视频地址
     */
    private String livenessBucket_url;

    private String longitude;
    private String latitude;
    private String address;
    private String livingAddress;
    private String nation;
    private Integer sex;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdated;
    private Integer version;


    public String getLivenessBucket_url() {
        return livenessBucket_url;
    }

    public void setLivenessBucket_url(String livenessBucket_url) {
        this.livenessBucket_url = livenessBucket_url;
    }

    public String getFrontCardBucket_url() {
        return frontCardBucket_url;
    }

    public void setFrontCardBucket_url(String frontCardBucket_url) {
        this.frontCardBucket_url = frontCardBucket_url;
    }

    public String getBackCardBucket_url() {
        return backCardBucket_url;
    }

    public void setBackCardBucket_url(String backCardBucket_url) {
        this.backCardBucket_url = backCardBucket_url;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getFrontCardBucket() {
        return frontCardBucket;
    }

    public void setFrontCardBucket(String frontCardBucket) {
        this.frontCardBucket = frontCardBucket;
    }

    public String getFrontCardObjectId() {
        return frontCardObjectId;
    }

    public void setFrontCardObjectId(String frontCardObjectId) {
        this.frontCardObjectId = frontCardObjectId;
    }

    public String getBackCardBucket() {
        return backCardBucket;
    }

    public void setBackCardBucket(String backCardBucket) {
        this.backCardBucket = backCardBucket;
    }

    public String getBackCardObjectId() {
        return backCardObjectId;
    }

    public void setBackCardObjectId(String backCardObjectId) {
        this.backCardObjectId = backCardObjectId;
    }

    public String getLivenessBucket() {
        return livenessBucket;
    }

    public void setLivenessBucket(String livenessBucket) {
        this.livenessBucket = livenessBucket;
    }

    public String getLivenessObjectId() {
        return livenessObjectId;
    }

    public void setLivenessObjectId(String livenessObjectId) {
        this.livenessObjectId = livenessObjectId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getLivingAddress() {
        return livingAddress;
    }

    public void setLivingAddress(String livingAddress) {
        this.livingAddress = livingAddress;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
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
}
