package cn.tdw.dao;


import cn.tdw.dto.StatisticsTaskDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;


/**
 * Created by wuganqin on 2017/8/15.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CollectionTaskDAOTest {



    @Autowired
    private  CollectionTaskDAO collectionTaskDAO;

    @Test
    public void queryStatisticsTasks() throws Exception {
        LocalDateTime startTime = LocalDate.now().atTime(0, 0, 0);
        List<StatisticsTaskDTO> list = collectionTaskDAO.queryStatisticsTasks(startTime, startTime.plusDays(1));
        Assert.assertNotNull(list);
    }
}