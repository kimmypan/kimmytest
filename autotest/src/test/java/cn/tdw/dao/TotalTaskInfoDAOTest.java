package cn.tdw.dao;

import cn.tdw.dto.TraceDetailTotalDTO;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * Created by wuganqin on 2017/8/24.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class TotalTaskInfoDAOTest {

    @Autowired
    TotalTaskInfoDAO dao;

    @Test
    public void queryTraceDetailTotal() throws Exception {
        TraceDetailTotalDTO dto = dao.queryTraceDetailTotal();
        Assert.assertNotNull(dto);
    }

}