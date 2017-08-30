package cn.tdw.domain;

import java.sql.Date;

import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * 用户基础信息
 * Created by huangzhenwie on 2017/8/14.
 */
public class UserBasicInfo {
    /**
     * 用户编号
     */
    private String userId;

    /**
     * 用户名
     */
    private String userName;
    /**
     * 用户密码
     */
    private String userPwd;
    /**
     * y用户性别
     */
    private Integer sex;
    /**
     * 用户信用额度
     */
    private Integer creditAmount;

    /**
     * 已使用额度
     */
    private Integer usedCreditAmount;

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
     * 提额时间
     */
    private LocalDateTime creditDate;
    /**
     * 真实姓名
     */
    private String realName;
    /**
     * 昵称
     */
    private String nickName;
    /**
     * 用户状态
     */
    private Integer userStatus;
    /**
     * 身份证
     */
    private String identityCard;
    /**
     * 身份证有效期
     */
    private String identityCardValidityDate;
    /**
     * 出生日期
     */
    private LocalDate birthdate;
    /**
     * 民族
     */
    private String nation;
    /**
     * 签证机关
     */
    private String visaAgency;
    /**
     * 登录时间
     */
    private LocalDateTime loginDate;
    /**
     * 登录失败次数
     */
    private Integer loginFailCount;
    /**
     * 银行卡号
     */
    private String bankNo;
    /**
     * 银行卡省
     */
    private String bankProvice;
    /**
     * 银行卡市
     */
    private String bankCity;
    /**
     * 开卡行
     */
    private String bankName;
    /**
     * 手机号
     */
    private String telNo;
    /**
     * 消息通知
     */
    private Boolean messageNotification;
    /**
     * 头像
     */
    private String headImage;
    /**
     * 正面身份证
     */
    private String frontCard;
    /**
     * 背面身份证
     */
    private String backCard;
    /**
     * 活体视频
     */
    private String liveVideo;
    /**
     * 邀请
     */
    private String extenderKey;
    /**
     * 创建时间
     */
    private LocalDateTime createDate;
    /**
     * 修改时间
     */
    private LocalDateTime lastUpdated;
    /**
     * version
     */
    private Integer version;
    /**
     * 年龄
     */
    private Long age;

    /**
     * 可用额度
     */
    private Integer usableAmount;

    /**
     * 芝麻分
     */
    private String zmscore;

    /**
     * 平台来源
     */
    private String channelName;

    /**
     * 户籍地址
     */
    private String address;

    /**
     * 身份证正面url
     */
    private String frontCard_url;
    /**
     * 身份证反面url
     */
    private String backCard_url;
    /**
     * 活体视频url
     */
    private String liveVideo_url;

    /**
     * 活体认证分数
     */
    private Integer verifyScore;

    /**实名和活体认证状态*/
    private Integer identityState;

    public Integer getIdentityState() {
        return identityState;
    }

    public void setIdentityState(Integer identityState) {
        this.identityState = identityState;
    }

    public Integer getVerifyScore() {
        return verifyScore;
    }

    public void setVerifyScore(Integer verifyScore) {
        this.verifyScore = verifyScore;
    }

    public String getBackCard_url() {
        return backCard_url;
    }

    public void setBackCard_url(String backCard_url) {
        this.backCard_url = backCard_url;
    }

    public String getLiveVideo_url() {
        return liveVideo_url;
    }

    public void setLiveVideo_url(String liveVideo_url) {
        this.liveVideo_url = liveVideo_url;
    }

    public String getFrontCard_url() {

        return frontCard_url;
    }

    public void setFrontCard_url(String frontCard_url) {
        this.frontCard_url = frontCard_url;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
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

    public String getChannelName() {
        return channelName;
    }

    public void setChannelName(String channelName) {
        this.channelName = channelName;
    }

    public String getZmscore() {
        return zmscore;
    }

    public void setZmscore(String zmscore) {
        this.zmscore = zmscore;
    }

    public Integer getUsableAmount() {
        return usableAmount;
    }

    public void setUsableAmount(Integer usableAmount) {
        this.usableAmount = usableAmount;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserPwd() {
        return userPwd;
    }

    public void setUserPwd(String userPwd) {
        this.userPwd = userPwd;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getCreditAmount() {
        return creditAmount;
    }

    public void setCreditAmount(Integer creditAmount) {
        this.creditAmount = creditAmount;
    }

    public Integer getUsedCreditAmount() {
        return usedCreditAmount;
    }

    public void setUsedCreditAmount(Integer usedCreditAmount) {
        this.usedCreditAmount = usedCreditAmount;
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

    public LocalDateTime getCreditDate() {
        return creditDate;
    }

    public void setCreditDate(LocalDateTime creditDate) {
        this.creditDate = creditDate;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public Integer getUserStatus() {
        return userStatus;
    }

    public void setUserStatus(Integer userStatus) {
        this.userStatus = userStatus;
    }

    public String getIdentityCard() {
        return identityCard;
    }

    public void setIdentityCard(String identityCard) {
        this.identityCard = identityCard;
    }

    public String getIdentityCardValidityDate() {
        return identityCardValidityDate;
    }

    public void setIdentityCardValidityDate(String identityCardValidityDate) {
        this.identityCardValidityDate = identityCardValidityDate;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getVisaAgency() {
        return visaAgency;
    }

    public void setVisaAgency(String visaAgency) {
        this.visaAgency = visaAgency;
    }

    public LocalDateTime getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(LocalDateTime loginDate) {
        this.loginDate = loginDate;
    }

    public Integer getLoginFailCount() {
        return loginFailCount;
    }

    public void setLoginFailCount(Integer loginFailCount) {
        this.loginFailCount = loginFailCount;
    }

    public String getBankNo() {
        return bankNo;
    }

    public void setBankNo(String bankNo) {
        this.bankNo = bankNo;
    }

    public String getBankProvice() {
        return bankProvice;
    }

    public void setBankProvice(String bankProvice) {
        this.bankProvice = bankProvice;
    }

    public String getBankCity() {
        return bankCity;
    }

    public void setBankCity(String bankCity) {
        this.bankCity = bankCity;
    }

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public Boolean getMessageNotification() {
        return messageNotification;
    }

    public void setMessageNotification(Boolean messageNotification) {
        this.messageNotification = messageNotification;
    }

    public String getHeadImage() {
        return headImage;
    }

    public void setHeadImage(String headImage) {
        this.headImage = headImage;
    }

    public String getFrontCard() {
        return frontCard;
    }

    public void setFrontCard(String frontCard) {
        this.frontCard = frontCard;
    }

    public String getBackCard() {
        return backCard;
    }

    public void setBackCard(String backCard) {
        this.backCard = backCard;
    }

    public String getLiveVideo() {
        return liveVideo;
    }

    public void setLiveVideo(String liveVideo) {
        this.liveVideo = liveVideo;
    }

    public String getExtenderKey() {
        return extenderKey;
    }

    public void setExtenderKey(String extenderKey) {
        this.extenderKey = extenderKey;
    }
}
