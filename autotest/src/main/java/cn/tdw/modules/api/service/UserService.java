package cn.tdw.modules.api.service;


import cn.tdw.modules.api.entity.UserEntity;

import java.util.List;
import java.util.Map;

/**
 * 用户
 * 
 *
 *
 * @date 2017-03-23 15:22:06
 */
public interface UserService {

	UserEntity queryObject(Long userId);
	
	List<UserEntity> queryList(Map<String, Object> map);
	
	int queryTotal(Map<String, Object> map);
	
	void save(String mobile, String password);
	
	void update(UserEntity user);
	
	void delete(Long userId);
	
	void deleteBatch(Long[] userIds);

	UserEntity queryByMobile(String mobile);

	UserEntity queryByUserName(String userName);

	/**
	 * 用户登录
	 * @param mobile    手机号
	 * @param password  密码
	 * @return          返回用户ID
	 */
	long login(String mobile, String password);
}
