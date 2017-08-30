package cn.tdw.modules.api.dao;

import cn.tdw.modules.api.entity.UserEntity;
import cn.tdw.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

/**
 * 用户
 * 
 *
 *
 * @date 2017-03-23 15:22:06
 */
@Mapper
public interface UserDao extends BaseDao<UserEntity> {

    UserEntity queryByMobile(String mobile);

    UserEntity queryByUserName(String userName);

}
