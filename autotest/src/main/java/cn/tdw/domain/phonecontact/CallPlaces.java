/**
  * Copyright 2017 bejson.com 
  */
package cn.tdw.domain.phonecontact;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;

/**
 * Auto-generated: 2017-08-29 10:55:21
 *
 * @author bejson.com (i@bejson.com)
 * @website http://www.bejson.com/java2pojo/
 */
@JsonIgnoreProperties({ "handler","hibernateLazyInitializer" })
public class CallPlaces implements Serializable {

    public String placeName;
    public int placeTimes;
    public void setPlaceName(String placeName) {
         this.placeName = placeName;
     }
     public String getPlaceName() {
         return placeName;
     }

    public void setPlaceTimes(int placeTimes) {
         this.placeTimes = placeTimes;
     }
     public int getPlaceTimes() {
         return placeTimes;
     }

}