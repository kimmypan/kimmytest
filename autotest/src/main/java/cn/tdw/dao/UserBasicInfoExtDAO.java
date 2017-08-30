package cn.tdw.dao;

import cn.tdw.domain.UserBasicInfoExt;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

/**
 * Created by huangzhenwei on 2017/8/17.
 */
@Mapper
public interface UserBasicInfoExtDAO {
    /**
     * 查看身份证照片
     * @param userId
     * @return
     */
    UserBasicInfoExt SelecUserInfoExt(@Param("userId")String userId);


}
