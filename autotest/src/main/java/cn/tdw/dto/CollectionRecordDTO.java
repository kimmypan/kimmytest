package cn.tdw.dto;

import java.time.LocalDateTime;

/**
 * Created by huangzhenwei  on 2017/8/17.
 */
public class CollectionRecordDTO {

    /**
     * 催收情况
     */
    private String collectionInfo;
    /**
     * 借款Id
     */
    private String borrowId;

    /**用户ID*/
    private  String userId;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getBorrowId() {
        return borrowId;
    }

    public void setBorrowId(String borrowId) {
        this.borrowId = borrowId;
    }

    public String getCollectionInfo() {
        return collectionInfo;
    }

    public void setCollectionInfo(String collectionInfo) {
        this.collectionInfo = collectionInfo;
    }
}
