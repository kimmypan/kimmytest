package cn.tdw.domain;

import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;

/**
 * 天秤
 * Created by huangzhenwei  on 2017/8/17.
 */
public class ApiData {
    /**
     * id
     */
    private Long dataId;
    /**
     * 天秤分配功能号
     */
    private String functionCode;
    /**
     * 排序
     */
    private String desc;
    /**
     * 返回数据
     */
    private String responseBusiData;
    /**
     * 接口返回的状态码
     */
    private String responseCode;
    /**
     * 接口返回状态描述
     */
    private String responseMsg;
    /**
     * 数据有效期
     */
    private LocalDateTime validTime;
    /**
     * 用户Id
     */
    private String userId;
    /**
     * 数据状态
     */
    private Integer resultStatus;
    /**
     * 创建时间
     */
    /**
     * 年龄
     */
    private Long age;

    /**
     * 考拉黑名单 1/2
     * 手机是否实名T/F/N
     * 手机时长A-Z[时间段]
     */
    //
    private String result;

    /**
     * 前海征信
     * E000996/E000000/ELSE
     */
    private String erCode;
    /**
     * 百融防欺诈-黑名单
     * 100002(key值)
     */
    private String specialList_c;

    /**
     * 百融多次申请考查信息
     */

    private String applyloanstr;

    /**
     * 考拉接口存值(黑名单)
     */
    private String back_h;

    /**
     * 考拉接口（手机是否实名）
     */
    private String phone_result;

    /**
     * 手机时长
     */
    private String phone_time;

    /**
     * 芝麻分值
     */
    private String zmscore;

    /**
     * 天秤网贷
     */
    private Integer datas;
    /**
     * 天籁自由黑名单
     */
    private Integer selfltit;

    /**
     * 老赖黑名单
     */
    private Integer deadbealfit;


    public Integer getDeadbealfit() {
        return deadbealfit;
    }

    public void setDeadbealfit(Integer deadbealfit) {
        this.deadbealfit = deadbealfit;
    }

    public Integer getDatas() {
        return datas;
    }

    public void setDatas(Integer datas) {
        this.datas = datas;
    }

    public Integer getSelfltit() {
        return selfltit;
    }

    public void setSelfltit(Integer selfltit) {
        this.selfltit = selfltit;
    }

    public String getZmscore() {
        return zmscore;
    }

    public void setZmscore(String zmscore) {
        this.zmscore = zmscore;
    }

    public String getBack_h() {
        return back_h;
    }

    public void setBack_h(String back_h) {
        this.back_h = back_h;
    }

    public String getPhone_result() {
        return phone_result;
    }

    public void setPhone_result(String phone_result) {
        this.phone_result = phone_result;
    }

    public String getPhone_time() {
        return phone_time;
    }

    public void setPhone_time(String phone_time) {
        this.phone_time = phone_time;
    }

    public String getResult() {
        return result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getErCode() {
        return erCode;
    }

    public void setErCode(String erCode) {
        this.erCode = erCode;
    }

    public String getSpecialList_c() {
        return specialList_c;
    }

    public void setSpecialList_c(String specialList_c) {
        this.specialList_c = specialList_c;
    }

    private LocalDateTime createDate;
    private LocalDateTime lastUpdated;
    private Integer isDelete;
    private Integer version;

    public String getApplyloanstr() {
        return applyloanstr;
    }

    public void setApplyloanstr(String applyloanstr) {
        this.applyloanstr = applyloanstr;
    }

    public Long getAge() {
        return age;
    }

    public void setAge(Long age) {
        this.age = age;
    }


    public Long getDataId() {
        return dataId;
    }

    public void setDataId(Long dataId) {
        this.dataId = dataId;
    }

    public String getFunctionCode() {
        return functionCode;
    }

    public void setFunctionCode(String functionCode) {
        this.functionCode = functionCode;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public String getResponseBusiData() {
        return responseBusiData;
    }

    public void setResponseBusiData(String responseBusiData) {
        this.responseBusiData = responseBusiData;
    }

    public String getResponseCode() {
        return responseCode;
    }

    public void setResponseCode(String responseCode) {
        this.responseCode = responseCode;
    }

    public String getResponseMsg() {
        return responseMsg;
    }

    public void setResponseMsg(String responseMsg) {
        this.responseMsg = responseMsg;
    }

    public LocalDateTime getValidTime() {
        return validTime;
    }

    public void setValidTime(LocalDateTime validTime) {
        this.validTime = validTime;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getResultStatus() {
        return resultStatus;
    }

    public void setResultStatus(Integer resultStatus) {
        this.resultStatus = resultStatus;
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

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
