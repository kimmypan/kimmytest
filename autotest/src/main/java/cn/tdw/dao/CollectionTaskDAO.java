package cn.tdw.dao;

import cn.tdw.domain.CollectionTask;
import cn.tdw.dto.*;
import cn.tdw.modules.sys.dao.BaseDao;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Map;

/**
 * Created by wuganqin on 2017/8/15.
 */
public interface CollectionTaskDAO extends BaseDao<CollectionTask> {

    List<StatisticsTaskDTO> queryStatisticsTasks(@Param("startTime") LocalDateTime startTime,@Param("endTime") LocalDateTime endTime);

    List<TrackersInfoDTO> getTrackerList(TrackersInfoSearchDTO trackersInfoSearchDTO);

    Integer updatePatchTrackerId(@Param("borrowIds") List<String> borrowIds, @Param("trackerId") Long trackerId);

    List<AllocationsInfoDTO> listTaskNotAllot(AllocationsInfoSearchDTO searchDTO);

    Long countTaskNotAllot();

    List<CollectionTask> listByBorrowIds(List borrowIds);

    void addBatchCollectionTask(Map paramsMap);

    Long countTaskAllot();

    List<CollectionTask> lockRecord(@Param("borrowIds") List<String> borrowIds);
}
