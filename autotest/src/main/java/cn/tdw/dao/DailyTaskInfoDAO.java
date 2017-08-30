package cn.tdw.dao;

import cn.tdw.dto.AllocationDetailDTO;
import cn.tdw.dto.AllocationDetailTotalDTO;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * Created by wuganqin on 2017/8/14.
 */
@Mapper
public interface DailyTaskInfoDAO extends TaskInfoDAO {

    List<AllocationDetailDTO> queryAllocationDetails(@Param("dayDate") String dayDate, @Param("monthDate") String monthDate);

    AllocationDetailTotalDTO queryAllocationDetailTotal(@Param("dayDate") String dayDate, @Param("monthDate") String monthDate);

    int queryTrackerCount();


}
