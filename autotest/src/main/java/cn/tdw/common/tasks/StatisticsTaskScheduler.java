package cn.tdw.common.tasks;


import cn.tdw.service.StatisticsTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

/**
 * Created by wuganqin on 2017/8/15.
 */
@Component
public class StatisticsTaskScheduler {
    @Autowired
    private StatisticsTaskService statisticsTaskService;

    /**
     * 插入
     * total_task_info
     * monthly_task_info
     * daily_task_info
     */
    @Scheduled(cron = "0 */1 * * * ?")
    public void doTask()  {
        statisticsTaskService.doWork();
    }



}
