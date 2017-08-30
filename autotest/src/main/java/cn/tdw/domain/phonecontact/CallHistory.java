/**
  * Copyright 2017 bejson.com 
  */
package cn.tdw.domain.phonecontact;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

/**
 * Auto-generated: 2017-08-29 10:55:21
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class CallHistory implements Serializable {

    public Long firstCallTime;
    public String phone;
    public int timeDuration;
    public List<CallPlaces> callPlaces;
    public Long lastCallTime;
    public int concactTimes;
    public int isRelationUser;
    public int isOverdueRepay;
    public int isCurrentOverdue;
    public int calledTimes;
    public int isIssueLoan;
    public int callTimes;
    public int isNwUser;
    public String phonePlace;


    public Long getFirstCallTime() {
        return firstCallTime;
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

    public void setPhone(String phone) {
         this.phone = phone;
     }
     public String getPhone() {
         return phone;
     }

    public void setTimeDuration(int timeDuration) {
         this.timeDuration = timeDuration;
     }
     public int getTimeDuration() {
         return timeDuration;
     }

    public void setCallPlaces(List<CallPlaces> callPlaces) {
         this.callPlaces = callPlaces;
     }
     public List<CallPlaces> getCallPlaces() {
         return callPlaces;
     }


    public void setConcactTimes(int concactTimes) {
         this.concactTimes = concactTimes;
     }
     public int getConcactTimes() {
         return concactTimes;
     }

    public void setIsRelationUser(int isRelationUser) {
         this.isRelationUser = isRelationUser;
     }
     public int getIsRelationUser() {
         return isRelationUser;
     }

    public void setIsOverdueRepay(int isOverdueRepay) {
         this.isOverdueRepay = isOverdueRepay;
     }
     public int getIsOverdueRepay() {
         return isOverdueRepay;
     }

    public void setIsCurrentOverdue(int isCurrentOverdue) {
         this.isCurrentOverdue = isCurrentOverdue;
     }
     public int getIsCurrentOverdue() {
         return isCurrentOverdue;
     }

    public void setCalledTimes(int calledTimes) {
         this.calledTimes = calledTimes;
     }
     public int getCalledTimes() {
         return calledTimes;
     }

    public void setIsIssueLoan(int isIssueLoan) {
         this.isIssueLoan = isIssueLoan;
     }
     public int getIsIssueLoan() {
         return isIssueLoan;
     }

    public void setCallTimes(int callTimes) {
         this.callTimes = callTimes;
     }
     public int getCallTimes() {
         return callTimes;
     }

    public void setIsNwUser(int isNwUser) {
         this.isNwUser = isNwUser;
     }
     public int getIsNwUser() {
         return isNwUser;
     }

    public void setPhonePlace(String phonePlace) {
         this.phonePlace = phonePlace;
     }
     public String getPhonePlace() {
         return phonePlace;
     }

}