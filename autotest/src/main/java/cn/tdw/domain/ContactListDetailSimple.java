package cn.tdw.domain;

import cn.tdw.domain.phonecontact.ContactListDetail;
import cn.tdw.domain.phonecontact.ContactListPhoneDetail;
import cn.tdw.domain.phonecontact.PhoneStatus;
import io.swagger.models.auth.In;

import java.util.List;

/**
 * Created by huangzhenwei on 2017/8/28.
 */
public class ContactListDetailSimple {
    /**
     * 姓名
     */
    private String phoneName;
    /**
     * 通讯录号码
     */
    private String phoneNum;
    /**
     * 是否正常
     */
    private String phoneStatus;
    /**
     * 6个月通话次数
     */
    private Integer concactTimes;
    /**
     * 是否预留联系人
     */
    private Integer isRelationUser;
    /**
     * 是否在你我金融注册
     */
    private Integer isNwUser;
    /**
     * 是否在你我金融发布借款
     */
    private Integer isIssueLoan;
    /**
     * 是否在你我金融存在还款逾期
     */
    private Integer isOverdueRepay;
    /**
     * 是否在当前在你我金融处于逾期状态
     */
    private Integer isCurrentOverdue;

    /**
     * 有通话记录（通话率）
     */
    private Integer matchPhones;

    /**
     * 更新时间
     */
    private String updateTime;
    /**
     * 总页数
     */
    private Integer page;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public String getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(String updateTime) {
        this.updateTime = updateTime;
    }

    public ContactListDetailSimple() {

    }

    public String getPhoneStatus() {
        return phoneStatus;
    }

    public void setPhoneStatus(String phoneStatus) {
        this.phoneStatus = phoneStatus;
    }

    public Integer getIsRelationUser() {
        return isRelationUser;
    }

    public void setIsRelationUser(Integer isRelationUser) {
        this.isRelationUser = isRelationUser;
    }

    public Integer getMatchPhones() {
        return matchPhones;
    }

    public void setMatchPhones(Integer matchPhones) {
        this.matchPhones = matchPhones;
    }

    public ContactListDetailSimple(ContactListPhoneDetail contactListPhoneDetail) {
        List<PhoneStatus> phoneStatus = contactListPhoneDetail.getPhoneStatus();
        String state = "";
        for (PhoneStatus stutas : phoneStatus) {
            if (stutas.getStatus() == 0) {
                state = "正常";
            }
            if (stutas.getStatus() == 1) {
                state = "异常（敏感词汇）";
            }
            if (stutas.getStatus() == 2) {
                state = "异常（短号）";
            }
            if (stutas.getStatus() == 3) {
                state = "异常（重复号码）";
            }
            if (stutas.getStatus() == 4) {
                state = "异常（格式错误）";
            }
            if (stutas.getStatus() == 5) {
                state = "异常（其它错误）";
            }
        }
     /*   this.phoneName = contactListPhoneDetail.getPhoneNum();*/
        this.phoneNum = contactListPhoneDetail.getPhoneNum();
        this.concactTimes = contactListPhoneDetail.getConcactTimes();
        this.isRelationUser = contactListPhoneDetail.getIsRelationUser();
        this.isNwUser = contactListPhoneDetail.getIsNwUser();
        this.isIssueLoan = contactListPhoneDetail.getIsIssueLoan();
        this.isOverdueRepay = contactListPhoneDetail.getIsOverdueRepay();
        this.isCurrentOverdue = contactListPhoneDetail.getIsCurrentOverdue();
        this.phoneStatus = state;
    }

    public String getPhoneName() {
        return phoneName;
    }

    public void setPhoneName(String phoneName) {
        this.phoneName = phoneName;
    }

    public String getPhoneNum() {
        return phoneNum;
    }

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }


    public Integer getConcactTimes() {
        return concactTimes;
    }

    public void setConcactTimes(Integer concactTimes) {
        this.concactTimes = concactTimes;
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


}
