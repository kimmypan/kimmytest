package cn.tdw.dao;

import cn.tdw.dto.FeedBackDTO;
import cn.tdw.dto.FeedBackSearchDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

/**
 * Created by wuganqin on 2017/8/14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FeedBackMapperTest {
    @Autowired
    FeedBackDAO feedBackMapper;

    @Test
    public void queryFeedBacks() throws Exception {
        FeedBackSearchDTO dto = new FeedBackSearchDTO();

        dto.setStartDate("2017-08-07");
        dto.setEndDate("2017-08-10");
        List<FeedBackDTO> feedBacks = feedBackMapper.queryFeedBacks(dto);

        System.out.println(feedBacks);

    }

}