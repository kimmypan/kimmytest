package cn.tdw.domain;

/**
 * Created by huangzhenwei on 2017/8/29.
 */
public class CallContactDetailSimple {
    /**
     * 通讯号码
     */
    private String phone;
    /**
     * callHistory通讯录姓名
     */
    private String name;
    /**
     * callHistory通话地点
     */
    private String callPlaces;
    /**
     * callHistory号码归属地
     */
    private String phonePlace;
    /**
     * callHistory联系次数
     */
    private Integer concactTimes;
    /**
     * callHistory主叫次数
     */
    private Integer callTimes;
    /**
     * callHistory被叫次数
     */
    private Integer calledTimes;
    /**
     * callHistory累计通话时间
     */
    private Integer timeDuration;
    /**
     * callHistory 6个月内首次通话时间
     */
    private Long firstCallTime;
    /**
     * 最后通话时间
     */
    private Long lastCallTime;
    /**
     * 有效通话记录
     */
    private Integer matchPhones;

    /**
     * callHistory是否预留联系人
     */
    private Integer isRelationUser;
    /**
     * callHistory是否在你我金融注册
     */
    private Integer isNwUser;
    /**
     * callHistory是否在你我金融发布借款
     */
    private Integer isIssueLoan;
    /**
     * callHistory是否在你我金融存在还款逾期
     */
    private Integer isOverdueRepay;
    /**
     * callHistory是否在当前在你我金融处于逾期状态
     */
    private Integer isCurrentOverdue;
    /**
     * callHisstory通话地点次数
     */
    private Integer placeTimes;

    /**
     * 近6个月有效通话次数≥4的手机号码数量
     */
    private Integer validCallNum;

    /**
     * 通话地点次数
     */
    private Integer placesTimes;

    public Integer getPlacesTimes() {
        return placesTimes;
    }

    public void setPlacesTimes(Integer placesTimes) {
        this.placesTimes = placesTimes;
    }

    public Integer getValidCallNum() {
        return validCallNum;
    }

    public void setValidCallNum(Integer validCallNum) {
        this.validCallNum = validCallNum;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCallPlaces() {
        return callPlaces;
    }

    public void setCallPlaces(String callPlaces) {
        this.callPlaces = callPlaces;
    }

    public String getPhonePlace() {
        return phonePlace;
    }

    public void setPhonePlace(String phonePlace) {
        this.phonePlace = phonePlace;
    }

    public Integer getConcactTimes() {
        return concactTimes;
    }

    public void setConcactTimes(Integer concactTimes) {
        this.concactTimes = concactTimes;
    }

    public Integer getCallTimes() {
        return callTimes;
    }

    public void setCallTimes(Integer callTimes) {
        this.callTimes = callTimes;
    }

    public Integer getCalledTimes() {
        return calledTimes;
    }

    public void setCalledTimes(Integer calledTimes) {
        this.calledTimes = calledTimes;
    }

    public Integer getTimeDuration() {
        return timeDuration;
    }

    public void setTimeDuration(Integer timeDuration) {
        this.timeDuration = timeDuration;
    }


    public void setFirstCallTime(Long firstCallTime) {
        this.firstCallTime = firstCallTime;
    }

    public Long getLastCallTime() {
        return lastCallTime;
    }

    public void setLastCallTime(Long lastCallTime) {
        this.lastCallTime = lastCallTime;
    }

    public Integer getMatchPhones() {
        return matchPhones;
    }

    public void setMatchPhones(Integer matchPhones) {
        this.matchPhones = matchPhones;
    }


    public Integer getIsRelationUser() {
        return isRelationUser;
    }

    public void setIsRelationUser(Integer isRelationUser) {
        this.isRelationUser = isRelationUser;
    }

    public Integer getIsNwUser() {
        return isNwUser;
    }

    public void setIsNwUser(Integer isNwUser) {
        this.isNwUser = isNwUser;
    }

    public Integer getIsIssueLoan() {
        return isIssueLoan;
    }

    public void setIsIssueLoan(Integer isIssueLoan) {
        this.isIssueLoan = isIssueLoan;
    }

    public Integer getIsOverdueRepay() {
        return isOverdueRepay;
    }

    public void setIsOverdueRepay(Integer isOverdueRepay) {
        this.isOverdueRepay = isOverdueRepay;
    }

    public Integer getIsCurrentOverdue() {
        return isCurrentOverdue;
    }

    public void setIsCurrentOverdue(Integer isCurrentOverdue) {
        this.isCurrentOverdue = isCurrentOverdue;
    }

    public Integer getPlaceTimes() {
        return placeTimes;
    }

    public void setPlaceTimes(Integer placeTimes) {
        this.placeTimes = placeTimes;
    }

    public Long getFirstCallTime() {
        return firstCallTime;
    }
}
