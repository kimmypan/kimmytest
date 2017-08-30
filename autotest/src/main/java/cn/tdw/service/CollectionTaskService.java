package cn.tdw.service;

import cn.tdw.common.constants.TaskEnum;
import cn.tdw.common.exception.RRException;
import cn.tdw.dao.*;
import cn.tdw.domain.BorrowInfo;
import cn.tdw.domain.CollectionAllocateLogs;
import cn.tdw.domain.CollectionTask;
import cn.tdw.dto.*;
import org.apache.commons.collections.map.HashedMap;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.*;

/**
 * @Author liubin
 * @Date 2017/8/14 10:52
 */
@Service
public class CollectionTaskService {
    private Logger logger = LoggerFactory.getLogger(CollectionTaskService.class);

    @Autowired
    private BorrowInfoDAO borrowInfoDAO;
    @Autowired
    private DailyTaskInfoDAO dailyTaskInfoDAO;
    @Autowired
    private TotalTaskInfoDAO totalTaskInfoDAO;

    @Autowired
    private CollectionTaskDAO collectionTaskDAO;

    @Autowired
    private CollectionAllocateLogsDAO collectionAllocateLogsDAO;

    public List<BorrowInfo> selectByCollectionTask(CollectionTaskSearchDTO searchDto) {
        return borrowInfoDAO.selectByCollectionTask(searchDto);
    }

    public List<AllocationDetailDTO> queryAllocationDetails() {
        LocalDate now = LocalDate.now();
        String day = now.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String month = now.format(DateTimeFormatter.ofPattern("yyyyMM"));
        return dailyTaskInfoDAO.queryAllocationDetails(day,month);
    }

    public AllocationDetailTotalDTO queryAllocationDetailTotal() {
        LocalDate now = LocalDate.now();
        String day = now.format(DateTimeFormatter.ofPattern("yyyyMMdd"));
        String month = now.format(DateTimeFormatter.ofPattern("yyyyMM"));
        int trackerCount = dailyTaskInfoDAO.queryTrackerCount();
        AllocationDetailTotalDTO detailTotal = dailyTaskInfoDAO.queryAllocationDetailTotal(day, month);
        detailTotal.setTrackerCount(trackerCount);
        return detailTotal;
    }

    public TraceDetailTotalDTO queryTraceDetailTotal() {
        return totalTaskInfoDAO.queryTraceDetailTotal();
    }


    public List<TraceDetailDTO> queryTraceDetails(TraceDetailSearchDTO dto) {



        return borrowInfoDAO.queryTraceDetails(dto);
    }

    /**
     * 催收未分配列表
     * @param searchDTO
     * @return
     */
    public List<AllocationsInfoDTO> listTaskNotAllot(AllocationsInfoSearchDTO searchDTO) {
        return collectionTaskDAO.listTaskNotAllot(searchDTO);
    }

    /**
     * 催收未分配总数
     * @return
     */
    public Long countTaskNotAllot() {
        return collectionTaskDAO.countTaskNotAllot();
    }

    /**
     * 催收分配未处理总数
     * @return
     */
    public Long countTaskAllot() {
        return collectionTaskDAO.countTaskAllot();
    }

    /**
     * 批量添加催收任务
     * @param trackerId 跟踪人
     * @param borrowIds 借款id
     * @return
     */
    public Map addBatchCollectionTask (Long trackerId, List<String> borrowIds, Long userId) {
        Map resultMap = new HashedMap();
        List<CollectionTask> tasks = collectionTaskDAO.listByBorrowIds(borrowIds);
        if (tasks != null && tasks.size() >= borrowIds.size()) {
            resultMap.put("existIds", borrowIds);
        } else {
            Set successIds = new HashSet();
            Set existIds = new HashSet();
            Set failIds = new HashSet();
            if (tasks != null && !tasks.isEmpty()) {
                tasks.forEach(task ->
                    existIds.add(task.getBorrowId())
                );
            }
            borrowIds.forEach(borrowId -> {
                if (!existIds.contains(borrowId)) {
                    try {
                        addCollectionTask(borrowId, trackerId, userId);
                        successIds.add(borrowId);
                    } catch (DuplicateKeyException duplicateKeyException) {
                        existIds.add(borrowId);
                    } catch (Exception e) {
                        failIds.add(borrowId);
                        logger.error("执行添加催收任务异常", e);
                    }
                }
            });
            resultMap.put("successIds", successIds);
            resultMap.put("existIds", existIds);
            resultMap.put("failIds", failIds);
        }
        return resultMap;
    }

    /**
     * 添加催收任务与日志
     * @param borrowId
     * @param trackerId
     * @param userId
     */
    @Transactional
    public void addCollectionTask(String borrowId, Long trackerId, Long userId) {
        CollectionTask task = new CollectionTask();
        task.setBorrowId(borrowId);
        task.setIsDeleted(TaskEnum.DeleteFlagEnum.NOT_DELETED.getValue());
        task.setTrackerId(trackerId);
        collectionTaskDAO.save(task);

        CollectionAllocateLogs log = new CollectionAllocateLogs();
        log.setBorrowId(borrowId);
        log.setOldTrackerId(TaskEnum.TRACKER_NOBODY);
        log.setNewTrackerId(trackerId);
        log.setOperatorId(userId.toString());
        log.setIsDeleted(TaskEnum.DeleteFlagEnum.NOT_DELETED.getValue());
        log.setOperateType(TaskEnum.OperateTypeEnum.ALLOT.getValue());
        collectionAllocateLogsDAO.save(log);
    }

    public TaskInfoDTO getStatistics(Long trackerId) {
        ArrayList<Long> list = new ArrayList<>();
        list.add(trackerId);
        List<TaskInfoDTO> totalTaskInfos = totalTaskInfoDAO.queryTaskInfoByTrackerIds(list);
        if (totalTaskInfos!=null && !totalTaskInfos.isEmpty()){
            return totalTaskInfos.get(0);
        }
        return null;
    }

    public List<AllocationsInfoDTO> selectAllocateWithoutResloveList(AllocationsInfoSearchDTO searchDTO) {
        return borrowInfoDAO.selectAllocateWithoutResloveList(searchDTO);
    }

    public List<TrackersInfoDTO> getTrackerList(TrackersInfoSearchDTO trackersInfoSearchDTO) {
        return collectionTaskDAO.getTrackerList(trackersInfoSearchDTO);
    }

    @Transactional
    public void transferTasks(List<String> borrowIds, List<Long> trackerIds, Long trackerId, Long loginId) {
        //锁任务分配表要更新的记录
        collectionTaskDAO.lockRecord(borrowIds);
        //更新任务分配表
        Integer result1 = collectionTaskDAO.updatePatchTrackerId(borrowIds, trackerId);
        if (borrowIds.size()!=result1){
            throw new RRException("更新任务分配表失败");
        }
        //添加工作移交操作记录
        List<Map<String,Object>> list = new ArrayList<>();
        if (borrowIds.size()==trackerIds.size()){
            for (int i = 0; i < borrowIds.size(); i++) {
                Map<String,Object> map = new HashMap<>();
                map.put("borrowId",borrowIds.get(i));
                map.put("trackerId",trackerIds.get(i));
                list.add(map);
            }
        }
        Integer result2 = collectionAllocateLogsDAO.insertPatchTransferLog(list,trackerId, loginId, TaskEnum.OperateTypeEnum.TRANSFER.getValue());
        if (result1!=result2){
            throw new RRException("更新催收分配日志表失败");
        }
    }
}
