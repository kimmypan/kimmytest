package cn.tdw.dao;

import cn.tdw.domain.CollectionAllocateLogs;
import cn.tdw.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Param;
import org.mapstruct.Mapper;

import java.util.List;
import java.util.Map;

/**
 * Created by yaodingguo on 2017/8/17.
 */
@Mapper
public interface CollectionAllocateLogsDAO extends BaseDao<CollectionAllocateLogs> {

    Integer insertPatchTransferLog(@Param("bt") List<Map<String,Object>> bt,
                                   @Param("trackerId") Long trackerId,
                                   @Param("operatorId") Long operatorId,
                                   @Param("operateType") Integer operateType);
}
