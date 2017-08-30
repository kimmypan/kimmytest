package cn.tdw.domain;

import java.time.LocalDateTime;

/**
 * 紧急联系人
 * Created by huangzhenwei on 2017/8/14.
 */

public class EmergencyContact {
    /**
     * 联系人编号
     */
    private Integer contactId;
    /**
     * 用户编号
     */
    private String userId;
    /**
     * 联系人名称
     */
    private String contactName;
    /**
     * 手机号码
     */
    private String contactTelNo;
    /**
     * 与本人关系
     */
    private String contactRelationShip;
    /**
     * 排序
     */
    private Integer sortOrder;
    /**
     * 创建时间
     */
    private LocalDateTime timestamp;
    /**
     * 修改时间
     */
    private LocalDateTime lastUpdated;

    public Integer getContactId() {
        return contactId;
    }

    public void setContactId(Integer contactId) {
        this.contactId = contactId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getContactName() {
        return contactName;
    }

    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public String getContactTelNo() {
        return contactTelNo;
    }

    public void setContactTelNo(String contactTelNo) {
        this.contactTelNo = contactTelNo;
    }

    public String getContactRelationShip() {
        return contactRelationShip;
    }

    public void setContactRelationShip(String contactRelationShip) {
        this.contactRelationShip = contactRelationShip;
    }

    public Integer getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(Integer sortOrder) {
        this.sortOrder = sortOrder;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public LocalDateTime getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(LocalDateTime lastUpdated) {
        this.lastUpdated = lastUpdated;
    }
}
