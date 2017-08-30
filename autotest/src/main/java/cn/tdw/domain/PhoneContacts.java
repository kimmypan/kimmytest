package cn.tdw.domain;

import java.time.LocalDateTime;

/**
 * Created by huangzhenwei on 2017/8/23.
 */
public class PhoneContacts {
    private Integer id;
    /**
     * 用户编号
     */
    private String userId;
    /**
     * 通讯录人员上传到阿里云ID
     */
    private String phoneContactsPath;
    /**
     * 通讯录分析上传到阿里云ID
     */
    private String callRecordsAnalyzePath;
    /**
     * 创建时间
     */
    private LocalDateTime createDate;
    /**
     * 通讯号码
     */
    private String phone;
    /**
     * 通讯录姓名
     */
    private String name;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPhoneContactsPath() {
        return phoneContactsPath;
    }

    public void setPhoneContactsPath(String phoneContactsPath) {
        this.phoneContactsPath = phoneContactsPath;
    }

    public String getCallRecordsAnalyzePath() {
        return callRecordsAnalyzePath;
    }

    public void setCallRecordsAnalyzePath(String callRecordsAnalyzePath) {
        this.callRecordsAnalyzePath = callRecordsAnalyzePath;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
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
}
