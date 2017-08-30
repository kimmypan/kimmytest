package cn.tdw.dto;

import java.time.LocalDateTime;

/**
 * Created by huangzhenwei on 2017/8/22.
 */
public class ApidataDTO {
    /**
     * 天秤分配功能号
     */
    private String functionCode;
    /**
     * 用户Id
     */
    private String userId;
    /**
     * 数据有效期
     */
    private LocalDateTime validTime;

    public String getFunctionCode() {
        return functionCode;
    }

    public void setFunctionCode(String functionCode) {
        this.functionCode = functionCode;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public LocalDateTime getValidTime() {
        return validTime;
    }

    public void setValidTime(LocalDateTime validTime) {
        this.validTime = validTime;
    }
}
