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
public class ContactListDetail implements Serializable {

    public int unNormalPhones;
    public String updateTime;
    public int matchPhones;
    public String deviceId;
    public String deviceType;
    public int phoneNumbers;
    public List<ContactListPhoneDetail> contactListPhoneDetail;
    public void setUnNormalPhones(int unNormalPhones) {
         this.unNormalPhones = unNormalPhones;
     }
     public int getUnNormalPhones() {
         return unNormalPhones;
     }

    public void setUpdateTime(String updateTime) {
         this.updateTime = updateTime;
     }
     public String getUpdateTime() {
         return updateTime;
     }

    public void setMatchPhones(int matchPhones) {
         this.matchPhones = matchPhones;
     }
     public int getMatchPhones() {
         return matchPhones;
     }

    public void setDeviceId(String deviceId) {
         this.deviceId = deviceId;
     }
     public String getDeviceId() {
         return deviceId;
     }

    public void setDeviceType(String deviceType) {
         this.deviceType = deviceType;
     }
     public String getDeviceType() {
         return deviceType;
     }

    public void setPhoneNumbers(int phoneNumbers) {
         this.phoneNumbers = phoneNumbers;
     }
     public int getPhoneNumbers() {
         return phoneNumbers;
     }

    public void setContactListPhoneDetail(List<ContactListPhoneDetail> contactListPhoneDetail) {
         this.contactListPhoneDetail = contactListPhoneDetail;
     }
     public List<ContactListPhoneDetail> getContactListPhoneDetail() {
         return contactListPhoneDetail;
     }

}