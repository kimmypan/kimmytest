package cn.tdw.dao;

import cn.tdw.dto.AllocationDetailDTO;
import cn.tdw.dto.AllocationDetailTotalDTO;
import cn.tdw.dto.StatisticsTaskDTO;
import cn.tdw.dto.TaskInfoDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by wuganqin on 2017/8/24.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class DailyTaskInfoDAOTest {
    @Autowired
    private DailyTaskInfoDAO dao;

    @Test
    public void queryAllocationDetails() throws Exception {
        List<AllocationDetailDTO> list = dao.queryAllocationDetails("20170824","201708");
        Assert.assertNotNull(list);
    }

    @Test
    public void queryAllocationDetailTotal() throws Exception {
        AllocationDetailTotalDTO dto = dao.queryAllocationDetailTotal("20170824", "201708");
        Assert.assertNotNull(dto);
    }

    @Test
    public void queryTrackerCount() throws Exception {
        int i = dao.queryTrackerCount();
    }

    @Test
    public void queryTaskInfoByAddDate() throws Exception {
        List<TaskInfoDTO> list = dao.queryTaskInfoByAddDate("20170824");
        Assert.assertNotNull(list);

    }

    @Test
    @Transactional
    public void batchInsertDailyTaskInfo() throws Exception {
        List<StatisticsTaskDTO> statisticsTasks = new ArrayList<>();
        StatisticsTaskDTO statisticsTaskDTO = new StatisticsTaskDTO();
        statisticsTaskDTO.setTrackerId(1111);
        statisticsTaskDTO.setRepayAmount(2222);
        statisticsTaskDTO.setAddDate("20170824");
        statisticsTasks.add(statisticsTaskDTO);
        dao.batchInsertTaskInfo(statisticsTasks);
    }

    @Test
    @Transactional
    public void batchUpdateTaskInfo() throws Exception {
        List<StatisticsTaskDTO> statisticsTasks = new ArrayList<>();
        StatisticsTaskDTO statisticsTaskDTO = new StatisticsTaskDTO();
        statisticsTaskDTO.setTrackerId(1111);
        statisticsTaskDTO.setRepayAmount(2222);
        statisticsTaskDTO.setAddDate("20170824");
        statisticsTasks.add(statisticsTaskDTO);
        dao.batchUpdateTaskInfo(statisticsTasks);
    }

}