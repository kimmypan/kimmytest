package cn.tdw.dao;

import cn.tdw.domain.CollectionRecord;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.util.List;

/**
 * Created by junte on 2017/8/14.
 */
@Mapper
public interface CollectionRecordDAO {
    //查询催收记录
    List<CollectionRecord> collectRecord(@Param("userId") String userId);
    //添加催收公共
    Integer insertCollectRecord(CollectionRecord record);



}
