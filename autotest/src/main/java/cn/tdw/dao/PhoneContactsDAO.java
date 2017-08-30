package cn.tdw.dao;

import cn.tdw.domain.PhoneContacts;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by huangzhenwei on 2017/8/28.
 */
@Mapper
public interface PhoneContactsDAO {

     PhoneContacts findContact(@Param("userId") String userId);
}
