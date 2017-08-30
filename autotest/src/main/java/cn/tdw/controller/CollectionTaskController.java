package cn.tdw.controller;

import cn.tdw.common.exception.RRException;
import cn.tdw.common.utils.R;
import cn.tdw.domain.BorrowInfo;
import cn.tdw.dto.*;
import cn.tdw.modules.sys.controller.AbstractController;
import cn.tdw.modules.sys.entity.SysUserEntity;
import cn.tdw.modules.sys.service.ShiroService;
import cn.tdw.modules.sys.service.SysUserService;
import cn.tdw.service.CollectionTaskService;
import com.tuandai.pagehelper.util.Page;
import com.tuandai.pagehelper.util.PageHelper;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @Author liubin
 * @Date 2017/8/14 8:36
 */
@RestController
@RequestMapping("/manager/collection")
public class CollectionTaskController  extends AbstractController {

    @Autowired
    private CollectionTaskService collectionTaskService;

    @Autowired
    private SysUserService sysUserService;

    @Autowired
    private ShiroService shiroService;

    @RequestMapping(value = "/tasks", method = RequestMethod.GET)
    public Page<BorrowInfo> listTask(Integer page, Integer limit) {

        Page<BorrowInfo> pageObject = PageHelper.startPage(page, limit);

        List<BorrowInfo> borrowInfoList = collectionTaskService.selectByCollectionTask(new CollectionTaskSearchDTO());
        pageObject.setDataList(borrowInfoList);

        return pageObject;
    }

    /**
     * 工作催收未分配
     * @param searchDTO
     * @return
     */
    @RequestMapping(value = "/tasksNotAllot", method = RequestMethod.GET)
    public R listTaskNotAllot(AllocationsInfoSearchDTO searchDTO) {

        Page<AllocationsInfoDTO> pager = null;
        List<AllocationsInfoDTO>  allots = null;
        //未分配总数
        Long notAllotCount = collectionTaskService.countTaskNotAllot();
        if (notAllotCount == null) {
            notAllotCount = 0L;
        }
        if (notAllotCount <= 0) {
            pager = new Page<>(searchDTO.getPage(), searchDTO.getLimit());
            allots = new ArrayList<>();
        } else {
            pager = PageHelper.startPage(searchDTO.getPage(), searchDTO.getLimit());
            allots = collectionTaskService.listTaskNotAllot(searchDTO);
        }
        pager.setDataList(allots);

        //已分配未处理总数
        Long allotedCount = collectionTaskService.countTaskAllot();
        if (allotedCount == null) {
            allotedCount = 0L;
        }

        return R.ok().put("page", pager).put("notAllotCount", notAllotCount).put("allotedCount", allotedCount);
    }

    /**
     *
     * 分配详情
     * @param page
     * @param limit
     * @return
     */
    @RequestMapping(value = "/allocationDetails", method = RequestMethod.GET)
    public R allocationDetails(Integer page, Integer limit) {
        Page<AllocationDetailDTO> pageObj = PageHelper.startPage(page, limit);
        pageObj.setDataList(collectionTaskService.queryAllocationDetails());
        return  R.ok().put("page",pageObj);
    }

    @RequestMapping(value = "/allocationDetailTotal", method = RequestMethod.GET)
    public R allocationDetailTotal() {
        return  R.ok().put("dto",collectionTaskService.queryAllocationDetailTotal());
    }



    /**
     * 项目详情头部
     * @return
     */
    @RequiresPermissions("collection:itemDetails:total")
    @RequestMapping(value = "/traceDetailTotal", method = RequestMethod.GET)
    public R traceDetailTotal() {
        return R.ok().put("dto", collectionTaskService.queryTraceDetailTotal());
    }

    /**
     * 项目详情
     * @return
     */
    @RequiresPermissions("collection:itemDetails:list")
    @RequestMapping(value = "/traceDetails", method = RequestMethod.GET)
    public R traceDetails(TraceDetailSearchDTO dto) {
        Page<TraceDetailDTO> pageObj = PageHelper.startPage(dto.getPage(), dto.getLimit());
        pageObj.setDataList(collectionTaskService.queryTraceDetails(dto));
        return  R.ok().put("page",pageObj);
    }

    /**
     * 跟踪人跟踪详情列表
     * @return
     */
    @RequiresPermissions("collection:trackerinfos:list")
    @RequestMapping(value = "/traceDetailsForOne", method = RequestMethod.GET)
    public R traceDetailsForOne(TraceDetailSearchDTO dto) {
        if (dto == null) {
            dto = new TraceDetailSearchDTO();
        }
        if (dto.getTrackerId() ==null){
            dto.setTrackerId(getUserId());
        }else {
            //判断用户是否有项目跟踪详情菜单的权限，以防用户修改sessionstorage
            Set<String> userPermissions = shiroService.getUserPermissions(getUserId());
            if (!userPermissions.contains("collection:itemDetails:list")){
                return R.error("您没有权限访问");
            }
        }
        Page<TraceDetailDTO> pageObj = PageHelper.startPage(dto.getPage(), dto.getLimit());
        pageObj.setDataList(collectionTaskService.queryTraceDetails(dto));
        return  R.ok().put("page",pageObj);
    }

    /**
     * 跟踪人跟踪详情信息统计
     * @param trackerId
     * @return
     */
    @RequiresPermissions("collection:trackerinfos:total")
    @GetMapping("trackerStatistics")
    public R trackerStatistics(Long trackerId){
        if (trackerId==null){
            trackerId=getUserId();
        }else {
            //判断用户是否有项目跟踪详情菜单的权限，以防用户修改sessionstorage
            Set<String> userPermissions = shiroService.getUserPermissions(getUserId());
            if (!userPermissions.contains("collection:itemDetails:list")){
                return R.error("您没有权限访问");
            }
        }
        return R.ok().put("trackerStatistics",collectionTaskService.getStatistics(trackerId));
    }

    /**
     * 执行催收分配
     * @param trackerId
     * @param borrowIds
     * @return
     */
    @RequestMapping(value ="/task/allot", method = RequestMethod.POST)
    public R doAllot(@RequestParam(name ="trackerId",required = false) Long trackerId, @RequestParam(name = "borrowIds[]",required = false) List borrowIds) {
        //检查是否可以操作
        if (trackerId == null) {
            return R.error("缺少跟踪人参数");
        }
        if (borrowIds == null || borrowIds.isEmpty()) {
            return R.error("缺少借款记录id数组参数");
        }
        Long userId = getUserId();
        if (userId == null || userId <= 0) {
            return R.error("未获取到操作用户");
        }
        SysUserEntity entity = sysUserService.queryObject(trackerId);
        if (entity == null) {
            return R.error("未找到待分配的员工");
        }
        Map result = collectionTaskService.addBatchCollectionTask(trackerId, borrowIds, userId);
        //操作
        return R.ok().put("result", result);
    }

    /**
     * 获取已分配未处理列表
     * @param searchDTO
     * @return
     */
    @GetMapping("allocateWithoutResloveList")
    public R allocateWithoutResloveList(AllocationsInfoSearchDTO searchDTO){
        Page<AllocationsInfoDTO> page = PageHelper.startPage(searchDTO.getPage(), searchDTO.getLimit());
        List<AllocationsInfoDTO> list = collectionTaskService.selectAllocateWithoutResloveList(searchDTO);
        page.setDataList(list);
        return R.ok().put("page",page);
    }

    /**
     * 获取可分配/移交人员列表
     * @param trackersInfoSearchDTO
     * @return
     */
    @GetMapping("trackerList")
    public R getTrackerList(TrackersInfoSearchDTO trackersInfoSearchDTO){
        Page<TrackersInfoDTO> page = PageHelper.startPage(trackersInfoSearchDTO.getPage(), trackersInfoSearchDTO.getLimit());
        List<TrackersInfoDTO> list = collectionTaskService.getTrackerList(trackersInfoSearchDTO);
        page.setDataList(list);
        return R.ok().put("page",page);
    }

    /**
     * 工作移交
     * @param borrowIds 借款记录borrowId列表
     * @param trackerIds 旧分配人trackerId列表，与borrowId顺序对应
     * @param trackerId 移交目标
     * @return
     */
    @PostMapping("transferTasks")
    public R transferTasks(@RequestParam("borrowIds[]") List borrowIds, @RequestParam("trackerIds[]")List<Long> trackerIds, @RequestParam("trackerId") Long trackerId){
        if (borrowIds==null || borrowIds.size()<=0){
            logger.error("参数为空,borrowIds:"+borrowIds);
            throw new RRException("参数为空");
        }
        if (trackerIds==null || trackerIds.size()<=0){
            logger.error("参数为空,trackerIds:"+trackerIds);
            throw new RRException("参数为空");
        }
        if (trackerId==null){
            logger.error("参数为空,trackerId:"+trackerId);
            throw new RRException("参数为空");
        }
        collectionTaskService.transferTasks(borrowIds,trackerIds,trackerId,getUserId());
        return R.ok("工作移交成功");
    }

    /**
     * 计算未分配/已分配未处理总数
     * @return
     */
    @GetMapping("countTask")
    public R countTask(){
        //未分配总数
        Long notAllotCount = collectionTaskService.countTaskNotAllot();
        //已分配未处理总数
        Long allotedCount = collectionTaskService.countTaskAllot();
        return R.ok().put("notAllotCount", notAllotCount).put("allotedCount", allotedCount);
    }
}
