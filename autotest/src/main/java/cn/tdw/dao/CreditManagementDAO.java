package cn.tdw.dao;

import cn.tdw.domain.CreditManagement;
import org.mapstruct.Mapper;

/**
 * Created by huangzhenwei on 2017/8/25.
 */
@Mapper
public interface CreditManagementDAO {

    //查看实名认证和活体认证及分数
    CreditManagement seleCreditManage(String userId);


}
