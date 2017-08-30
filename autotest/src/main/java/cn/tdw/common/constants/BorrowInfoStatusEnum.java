package cn.tdw.common.constants;

import org.apache.commons.collections.map.HashedMap;

import java.util.Map;

/**
 * Created by huangwenchang on 2017/8/15.
 */
public enum BorrowInfoStatusEnum {

    INITIATE(1, "发起借款"),
    ACTIVED(2, "已审核"),
    NOT_PASS(3, "未通过"),
    SECURED_LOAN(4, "已放款"),
    PENDING_REPAYMENT(5, "待还款"),
    SUCCESS(6, "已完成"),
    OVERDUE(7, "逾期"),
    SERIOUS_OVERDUE(8, "严重逾期");

    private int key;
    private String value;

    private BorrowInfoStatusEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public int getKey() {
        return key;
    }

    public String getValue() {
        return value;
    }

    /**
     * <p> 通过可以获取枚举的值</p>
     * @param key
     * @return
     * @throws
     */
    public static String getValueByKey(int key) {
        for (BorrowInfoStatusEnum en : BorrowInfoStatusEnum.values()){
            if ( en.key == key) {
                return en.value;
            }
        }
        return null;
    }


    /**
     * <p>通过key获取类型对象</p>
     * @param key
     * @return
     * @throws
     */
    public static BorrowInfoStatusEnum newInstance(int key) {
        for (BorrowInfoStatusEnum en : BorrowInfoStatusEnum.values()){
            if ( en.key == key ){
                return en;
            }
        }
        return null;
    }

}
