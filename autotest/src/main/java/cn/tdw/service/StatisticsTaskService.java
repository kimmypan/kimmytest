package cn.tdw.service;

import cn.tdw.common.constants.TaskInfoEnum;
import cn.tdw.common.exception.RRException;
import cn.tdw.common.tasks.StatisticsTaskScheduler;
import cn.tdw.dao.*;
import cn.tdw.dto.StatisticsTaskDTO;
import cn.tdw.dto.TaskInfoDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

import static java.util.stream.Collectors.groupingBy;
import static java.util.stream.Collectors.toList;

/**
 * Created by wuganqin on 2017/8/16.
 */
@Service
public class StatisticsTaskService {
    private Logger logger = LoggerFactory.getLogger(StatisticsTaskScheduler.class);
    private static final String YYYY_MM_DD = "yyyyMMdd";
    private static final String YYYY_MM = "yyyyMM";


    @Autowired
    private CollectionTaskDAO collectionTaskDAO;
    @Autowired
    private DailyTaskInfoDAO dailyTaskInfoDAO;
    @Autowired
    private MonthlyTaskInfoDAO monthlyTaskInfoDAO;
    @Autowired
    private TotalTaskInfoDAO totalTaskInfoDAO;


    /**
     * 插入
     * total_task_info
     * monthly_task_info
     * daily_task_info
     */
    @Transactional
    public void doWork() {
        try {

            //do daily_task_info
            LocalDate now = LocalDate.now();
            LocalDateTime start = now.atTime(0, 0, 0);
            LocalDateTime end = start.plusDays(1);
            doTaskInfo(TaskInfoEnum.DAILY, start, end);
            //do monthly_task_info
            start = now.withDayOfMonth(1).atTime(0, 0, 0);
            end = start.plusMonths(1);
            doTaskInfo(TaskInfoEnum.MONTHLY, start, end);
            //do total_task_info
            doTaskInfo(TaskInfoEnum.TOTAL, null, null);

        } catch (Exception e) {
            logger.info("StatisticsTask - doTask() 异常:{}", e);
            throw new RRException("定时插入统计表数据异常");
        }

    }




    private void doTaskInfo(TaskInfoEnum taskInfoEnum, LocalDateTime start, LocalDateTime end) {
        TaskInfoDAO taskInfoDAO = getTaskInfoDAO(taskInfoEnum);
        String pattern = TaskInfoEnum.MONTHLY == taskInfoEnum ? YYYY_MM : YYYY_MM_DD;
        //需要插入活更新的数据
        List<StatisticsTaskDTO> statisticsTasks = getStatisticsTasks(start, end, taskInfoEnum, pattern);

        //查询已经存在数据
        List<TaskInfoDTO> taskInfoList;
        if (TaskInfoEnum.TOTAL == taskInfoEnum) {
            List<Long> ids = statisticsTasks.stream().map(StatisticsTaskDTO::getTrackerId).collect(toList());
            taskInfoList = taskInfoDAO.queryTaskInfoByTrackerIds(ids);
        } else {
            taskInfoList = taskInfoDAO.queryTaskInfoByAddDate(LocalDate.now().format(DateTimeFormatter.ofPattern(pattern)));
        }

        //过滤数据
        Map<Integer, List<StatisticsTaskDTO>> collect = filterList(statisticsTasks, taskInfoList);

        //插入
        List<StatisticsTaskDTO> insertList = collect.get(1);
        if (insertList != null && !insertList.isEmpty()) {
            taskInfoDAO.batchInsertTaskInfo(insertList);
        }
        //更新
        List<StatisticsTaskDTO> updateList = collect.get(0);
        if (updateList != null && !updateList.isEmpty()) {
            taskInfoDAO.batchUpdateTaskInfo(updateList);
        }
    }

    /**
     *  查询需要插入或更新的数据
     * @param start
     * @param end
     * @param taskInfoEnum
     * @param pattern
     * @return
     */
    private List<StatisticsTaskDTO> getStatisticsTasks(LocalDateTime start, LocalDateTime end, TaskInfoEnum taskInfoEnum, String pattern) {
        List<StatisticsTaskDTO> statisticsTasks = collectionTaskDAO.queryStatisticsTasks(start, end);
        if (TaskInfoEnum.TOTAL != taskInfoEnum) {
            statisticsTasks.forEach(dto -> dto.setAddDate(LocalDate.now().format(DateTimeFormatter.ofPattern(pattern))));
        }
        return statisticsTasks;
    }

    /**
     * 获取对应的dao
     *
     * @param taskInfoEnum
     * @return
     */
    private TaskInfoDAO getTaskInfoDAO(TaskInfoEnum taskInfoEnum) {
        TaskInfoDAO taskInfoDAO = TaskInfoEnum.DAILY == taskInfoEnum ? dailyTaskInfoDAO : monthlyTaskInfoDAO;
        return TaskInfoEnum.TOTAL == taskInfoEnum ? totalTaskInfoDAO : taskInfoDAO;
    }

    /**
     * 根据trackerId 进行分组  0 需要更新的List,1 需要插入的List
     *
     * @param statisticsTasks
     * @param taskInfoList
     * @return
     */
    private Map<Integer, List<StatisticsTaskDTO>> filterList(List<StatisticsTaskDTO> statisticsTasks, List<TaskInfoDTO> taskInfoList) {
        return statisticsTasks.stream().collect(groupingBy(statisticsTask -> {
            if (taskInfoList.stream().anyMatch(taskInfo -> taskInfo.getTrackerId() == statisticsTask.getTrackerId())) {
                return 0;//update
            } else {
                return 1;//insert
            }
        }));
    }

}
