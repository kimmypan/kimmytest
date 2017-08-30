package cn.tdw.dto;

import cn.tdw.common.constants.BorrowInfoStatusEnum;
import cn.tdw.common.utils.excel.annotation.ExcelField;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.LocalDateTime;

/**
 * Created by wuganqin on 2017/8/17.
 */
public class TraceDetailDTO {
    private String userId;
    private String borrowId;
    @ExcelField(title = "客户姓名", align = 2, sort = 10)
    private String realName;
    @ExcelField(title = "手机号码", align = 2, sort = 10)
    private String telNo;
    @ExcelField(title = "还款状态", align = 2, sort = 10)
    private String statusText;
    private int status;
    private int overdueDays;
    @ExcelField(title = " 应还款日期", align = 2, sort = 10)
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss", timezone = "GMT+8")
    private LocalDateTime cycDate;
    @ExcelField(title = "回款金额", align = 2, sort = 10)
    private double repayAmount;
    @ExcelField(title = "待回款金额", align = 2, sort = 10)
    private double taskAmount;
    @ExcelField(title = "汇款类型", align = 2, sort = 10)
    private String repayType;
    @ExcelField(title = "分配时间", align = 2, sort = 10)
    private LocalDateTime createTime;
    @ExcelField(title = "跟踪人", align = 2, sort = 10)

    private String trackerName;
    private int trackerId;


    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getRepayType() {
        if(taskAmount>0){
            return "未回款";
        }else{
            return "全部回款";
        }
    }
    public String getStatusText() {
        if (this.status==6) {
            return BorrowInfoStatusEnum.getValueByKey(this.status);
        }else{
            return BorrowInfoStatusEnum.getValueByKey(this.status)+"（"+overdueDays+"）";
        }

    }
    public String getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(String borrowId) {
        this.borrowId = borrowId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getTelNo() {
        return telNo;
    }

    public void setTelNo(String telNo) {
        this.telNo = telNo;
    }

    public int getStatus() {
        return status;
    }

    public void setStatus(int status) {
        this.status = status;
    }

    public int getOverdueDays() {
        return overdueDays;
    }

    public void setOverdueDays(int overdueDays) {
        this.overdueDays = overdueDays;
    }

    public LocalDateTime getCycDate() {
        return cycDate;
    }

    public void setCycDate(LocalDateTime cycDate) {
        this.cycDate = cycDate;
    }

    public double getRepayAmount() {
        return repayAmount;
    }

    public void setRepayAmount(double repayAmount) {
        this.repayAmount = repayAmount;
    }

    public double getTaskAmount() {
        return taskAmount;
    }

    public void setTaskAmount(double taskAmount) {
        this.taskAmount = taskAmount;
    }

    public LocalDateTime getCreateTime() {
        return createTime;
    }

    public void setCreateTime(LocalDateTime createTime) {
        this.createTime = createTime;
    }

    public String getTrackerName() {
        return trackerName;
    }

    public void setTrackerName(String trackerName) {
        this.trackerName = trackerName;
    }

    public int getTrackerId() {
        return trackerId;
    }

    public void setTrackerId(int trackerId) {
        this.trackerId = trackerId;
    }
}
