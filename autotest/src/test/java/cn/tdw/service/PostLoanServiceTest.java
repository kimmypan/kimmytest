package cn.tdw.service;

import cn.tdw.common.constants.BorrowInfoStatusEnum;
import cn.tdw.dto.PostLoanDTO;
import cn.tdw.dto.PostLoanSearchDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDate;
import java.util.List;

/**
 * Created by huangwenchang on 2017/8/24.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class PostLoanServiceTest {
    @Autowired
    PostLoanService postLoanService;

    /**
     * 贷后管理列表
     */
    @Test
    public void listTest() {
        PostLoanSearchDTO searchDTO = new PostLoanSearchDTO();
        searchDTO.setStatus(7);
        searchDTO.setRealName("时勇");
        searchDTO.setTelNo("15000000021");
        searchDTO.setOverDueDaysBegin(1);
        searchDTO.setOverDueDaysEnd(10);
        searchDTO.setToday(LocalDate.now());
        searchDTO.setCycDateBegin("2017-08-21");
        searchDTO.setCycDateEnd("2017-08-21");
        searchDTO.setStatus(BorrowInfoStatusEnum.OVERDUE.getKey());
        searchDTO.setChannelId(88L);
        searchDTO.setTrackerId(5L);
//        searchDTO.setChannelId();
        List<PostLoanDTO> list = postLoanService.list(searchDTO);
        if (list != null && !list.isEmpty()) {
            list.forEach(o -> System.out.println(o.getBorrowId()));
        }
    }
}
