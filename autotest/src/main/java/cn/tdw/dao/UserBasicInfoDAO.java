package cn.tdw.dao;

import cn.tdw.domain.UserBasicInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.data.repository.query.Param;

/**
 * Created by junte on 2017/8/14.
 */
@Mapper
public interface UserBasicInfoDAO {
    /**
     * 查看用户基础信息表
     * @param userId
     * @return
     */
    UserBasicInfo seluserbasicinfo(@Param("userId")String userId);

}
