package cn.tdw.dao;

import cn.tdw.dto.StatisticsTaskDTO;
import cn.tdw.dto.TaskInfoDTO;

import java.util.List;

/**
 * Created by wuganqin on 2017/8/24.
 */
public interface TaskInfoDAO {

    List<TaskInfoDTO>  queryTaskInfoByAddDate(String addDate);
    List<TaskInfoDTO> queryTaskInfoByTrackerIds(List<Long> ids);

    void batchInsertTaskInfo(List<StatisticsTaskDTO> statisticsTasks);

    void batchUpdateTaskInfo(List<StatisticsTaskDTO> statisticsTasks);
}
