package cn.tdw.service;

import cn.tdw.common.constants.BorrowInfoStatusEnum;
import cn.tdw.common.constants.TaskEnum;
import cn.tdw.dto.*;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by yaodingguo on 2017/8/21.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class CollectionTaskServiceTest {

    @Autowired
    CollectionTaskService collectionTaskService;


    @Test
    public void queryAllocationDetails() throws Exception {
        List<AllocationDetailDTO> list = collectionTaskService.queryAllocationDetails();
        Assert.assertNotNull(list);
    }

    @Test
    public void queryAllocationDetailTotal() throws Exception {
        AllocationDetailTotalDTO dto = collectionTaskService.queryAllocationDetailTotal();
        Assert.assertNotNull(dto);
    }

    @Test
    public void queryTraceDetailTotal() throws Exception {
        TraceDetailTotalDTO dto = collectionTaskService.queryTraceDetailTotal();
        Assert.assertNotNull(dto);

    }

    @Test
    public void queryTraceDetails() throws Exception {
        TraceDetailSearchDTO dto=new TraceDetailSearchDTO();
        List<TraceDetailDTO> list = collectionTaskService.queryTraceDetails(dto);
        Assert.assertNotNull(list);

    }

    @Test
    public void selectAllocateWithoutResloveList() throws Exception {
        AllocationsInfoSearchDTO allocateWithoutResloveSearchDTO = new AllocationsInfoSearchDTO();
        List<AllocationsInfoDTO> borrowWithAllocateInfoDTOS = collectionTaskService.selectAllocateWithoutResloveList(allocateWithoutResloveSearchDTO);
        System.out.println(borrowWithAllocateInfoDTOS.size());
    }
    @Test
    public void getTrackerList(){
        TrackersInfoSearchDTO trackersInfoSearchDTO = new TrackersInfoSearchDTO();
        trackersInfoSearchDTO.setPage(1);
        trackersInfoSearchDTO.setLimit(10);
        List<TrackersInfoDTO> trackerList = collectionTaskService.getTrackerList(trackersInfoSearchDTO);
        System.out.println(trackerList.size());
    }
    @Test
    public void transferTasks(){
        List<String> list = new ArrayList<>();
        list.add("014C5E627E114A60A3E9CFB6EF84B26C");
        list.add("fa53896e-821d-11e7-b6df-0050568f7fba");
        List<Long> list1 = new ArrayList<>();
        list1.add(2l);
        list1.add(2l);
        collectionTaskService.transferTasks(list, list1,1l,1l);
    }

    /**
     * 催收未分配总数
     */
    @Test
    public void countTaskNotAllotTest() {
        System.out.println(collectionTaskService.countTaskNotAllot());
    }

    /**
     * 催收未分配列表
     */
    @Test
    public void listTaskNotAllotTest() {
        AllocationsInfoSearchDTO searchDTO = new AllocationsInfoSearchDTO();
        searchDTO.setUserName("时勇");
        searchDTO.setRepayStatue(BorrowInfoStatusEnum.SERIOUS_OVERDUE.getKey());
        searchDTO.setRepayBDate("2017-08-05");
        searchDTO.setRepayEDate("2017-08-05");
        searchDTO.setMobile("15000000021");
        searchDTO.setOverdueMinDay(1);
        searchDTO.setOverdueMaxDay(50);
        List<AllocationsInfoDTO> list = collectionTaskService.listTaskNotAllot(searchDTO);
        if (list != null && !list.isEmpty()) {
            list.forEach(o -> System.out.println(o.getBorrowId()));
        }
    }

    /**
     * 批量添加分配任务
     */
    @Test
    public void addBatchCollectionTask() {
        Long trackerId = 4L;
        List<String> borrowIds = new ArrayList<>();
        borrowIds.add("b410a5e0-86d7-11e7-b6df-0050568f7fba");
        borrowIds.add("b410f02b-86d7-11e7-b6df-0050568f7fba");
        System.out.println(collectionTaskService.addBatchCollectionTask(trackerId, borrowIds,trackerId));
    }
}