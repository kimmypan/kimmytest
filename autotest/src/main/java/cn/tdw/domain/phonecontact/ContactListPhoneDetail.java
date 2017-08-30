/**
  * Copyright 2017 bejson.com 
  */
package cn.tdw.domain.phonecontact;
import java.util.List;

/**
 * Auto-generated: 2017-08-29 10:55:21
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
public class ContactListPhoneDetail {

    private int isOverdueRepay;
    private String phoneNum;
    private int isCurrentOverdue;
    private int isIssueLoan;
    private List<PhoneStatus> phoneStatus;
    private int concactTimes;
    private int isNwUser;
    private int isRelationUser;
    public void setIsOverdueRepay(int isOverdueRepay) {
         this.isOverdueRepay = isOverdueRepay;
     }
     public int getIsOverdueRepay() {
         return isOverdueRepay;
     }

    public void setPhoneNum(String phoneNum) {
         this.phoneNum = phoneNum;
     }
     public String getPhoneNum() {
         return phoneNum;
     }

    public void setIsCurrentOverdue(int isCurrentOverdue) {
         this.isCurrentOverdue = isCurrentOverdue;
     }
     public int getIsCurrentOverdue() {
         return isCurrentOverdue;
     }

    public void setIsIssueLoan(int isIssueLoan) {
         this.isIssueLoan = isIssueLoan;
     }
     public int getIsIssueLoan() {
         return isIssueLoan;
     }

    public void setPhoneStatus(List<PhoneStatus> phoneStatus) {
         this.phoneStatus = phoneStatus;
     }
     public List<PhoneStatus> getPhoneStatus() {
         return phoneStatus;
     }

    public void setConcactTimes(int concactTimes) {
         this.concactTimes = concactTimes;
     }
     public int getConcactTimes() {
         return concactTimes;
     }

    public void setIsNwUser(int isNwUser) {
         this.isNwUser = isNwUser;
     }
     public int getIsNwUser() {
         return isNwUser;
     }

    public void setIsRelationUser(int isRelationUser) {
         this.isRelationUser = isRelationUser;
     }
     public int getIsRelationUser() {
         return isRelationUser;
     }

}