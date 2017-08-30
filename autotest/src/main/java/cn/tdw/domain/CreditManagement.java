package cn.tdw.domain;

import java.time.LocalDateTime;

/**
 * Created by huangzhenwei on 2017/8/25.
 */
public class CreditManagement {
    /**
     * 用户ID
     */
    private String userId;
    private Integer depositoryState;
    /**
     * 实名和活体认证状态
     */
    private Integer identityState;

    private Double confidence;

    private Double hackScore;
    //活体认证分数
    private Double verifyScore;
    private Integer mobileCarriersState;
    private LocalDateTime mobileCarriersDate;
    private Integer sesameCreditState;
    private Integer signatureState;
    private Integer signatureType;
    private Integer mergencyContactState;
    private Integer certificateStatus;
    private Integer certificateDate;
    private LocalDateTime createDate;
    private LocalDateTime lastUpdated;
    private Integer version;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getDepositoryState() {
        return depositoryState;
    }

    public void setDepositoryState(Integer depositoryState) {
        this.depositoryState = depositoryState;
    }

    public Integer getIdentityState() {
        return identityState;
    }

    public void setIdentityState(Integer identityState) {
        this.identityState = identityState;
    }

    public Double getConfidence() {
        return confidence;
    }

    public void setConfidence(Double confidence) {
        this.confidence = confidence;
    }

    public Double getHackScore() {
        return hackScore;
    }

    public void setHackScore(Double hackScore) {
        this.hackScore = hackScore;
    }

    public Double getVerifyScore() {
        return verifyScore;
    }

    public void setVerifyScore(Double verifyScore) {
        this.verifyScore = verifyScore;
    }

    public Integer getMobileCarriersState() {
        return mobileCarriersState;
    }

    public void setMobileCarriersState(Integer mobileCarriersState) {
        this.mobileCarriersState = mobileCarriersState;
    }

    public LocalDateTime getMobileCarriersDate() {
        return mobileCarriersDate;
    }

    public void setMobileCarriersDate(LocalDateTime mobileCarriersDate) {
        this.mobileCarriersDate = mobileCarriersDate;
    }

    public Integer getSesameCreditState() {
        return sesameCreditState;
    }

    public void setSesameCreditState(Integer sesameCreditState) {
        this.sesameCreditState = sesameCreditState;
    }

    public Integer getSignatureState() {
        return signatureState;
    }

    public void setSignatureState(Integer signatureState) {
        this.signatureState = signatureState;
    }

    public Integer getSignatureType() {
        return signatureType;
    }

    public void setSignatureType(Integer signatureType) {
        this.signatureType = signatureType;
    }

    public Integer getMergencyContactState() {
        return mergencyContactState;
    }

    public void setMergencyContactState(Integer mergencyContactState) {
        this.mergencyContactState = mergencyContactState;
    }

    public Integer getCertificateStatus() {
        return certificateStatus;
    }

    public void setCertificateStatus(Integer certificateStatus) {
        this.certificateStatus = certificateStatus;
    }

    public Integer getCertificateDate() {
        return certificateDate;
    }

    public void setCertificateDate(Integer certificateDate) {
        this.certificateDate = certificateDate;
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

    public Integer getVersion() {
        return version;
    }

    public void setVersion(Integer version) {
        this.version = version;
    }
}
