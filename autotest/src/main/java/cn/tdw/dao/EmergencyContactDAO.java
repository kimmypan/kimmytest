package cn.tdw.dao;

import cn.tdw.domain.EmergencyContact;
import org.mapstruct.Mapper;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 * Created by junte on 2017/8/14.
 */
@Mapper
public interface EmergencyContactDAO {
    /**
     * 查看紧急联系人
     * @param userId
     * @return
     */
    List<EmergencyContact> selemergencycontact(@Param("userId")String userId);


}
