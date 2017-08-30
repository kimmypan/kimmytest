package cn.tdw.service;

import cn.tdw.dto.FeedBackDTO;
import cn.tdw.dto.FeedBackSearchDTO;
import com.tuandai.pagehelper.util.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by wuganqin on 2017/8/14.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class FeedBackServiceTest {
    @Autowired
    FeedBackService feedBackService;

    @Test
    public void queryFeedBacks() throws Exception {

        FeedBackSearchDTO dto = new FeedBackSearchDTO();

        Page<FeedBackDTO> page = feedBackService.queryFeedBacks(dto);


        System.out.println("---");
    }

}