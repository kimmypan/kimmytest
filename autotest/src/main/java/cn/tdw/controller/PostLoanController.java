package cn.tdw.controller;

import cn.tdw.common.constants.BorrowInfoStatusEnum;
import cn.tdw.common.utils.R;
import cn.tdw.domain.ChannelBusiness;
import cn.tdw.domain.OverDueRecord;
import cn.tdw.dto.PostLoanDTO;
import cn.tdw.dto.PostLoanSearchDTO;
import cn.tdw.modules.sys.entity.SysUserEntity;
import cn.tdw.modules.sys.service.SysUserService;
import cn.tdw.service.ChannelBusinessService;
import cn.tdw.service.OverDueRecordService;
import cn.tdw.service.PostLoanService;
import com.tuandai.ms.utils.StringUtils;
import com.tuandai.pagehelper.util.Page;
import com.tuandai.pagehelper.util.PageHelper;
import org.apache.commons.collections.map.HashedMap;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * Created by huangwenchang on 2017/8/14.
 */
@RestController
@RequestMapping("manager/postLoan")
public class PostLoanController {

    @Autowired
    SysUserService sysUserService;

    @Autowired
    PostLoanService postLoanService;

    @Autowired
    ChannelBusinessService channelBusinessService;

    @Autowired
    OverDueRecordService overDueRecordService;

    /**
     * 贷后管理列表
     * @param searchDTO
     * @return
     */
    @RequestMapping(value = "infos")
    public R page(PostLoanSearchDTO searchDTO) {
        //渠道商
        List<ChannelBusiness> channelBusinessList = channelBusinessService.list();
        R r = R.ok().put("channelBusinessList", channelBusinessList).put("searchDTO", searchDTO);

        Page<PostLoanDTO> pager = PageHelper.startPage(searchDTO.getPage(), searchDTO.getLimit());
        if (StringUtils.isNotBlank(searchDTO.getTrackerName())) {
            SysUserEntity sysUserEntity = sysUserService.queryByNickName(searchDTO.getTrackerName());
            if (sysUserEntity == null || sysUserEntity.getUserId() == null) {
                return r;
            }
            searchDTO.setTrackerId(sysUserEntity.getUserId());
        }

        if (searchDTO.getOverDueDaysBegin() != null || searchDTO.getOverDueDaysEnd() != null) {
            searchDTO.setToday(LocalDate.now());
        }

        List<PostLoanDTO> postLoanList = postLoanService.list(searchDTO);
        pager.setDataList(postLoanList);
        if (postLoanList != null && !postLoanList.isEmpty()) {

            //设置跟踪人
            setTrackerForObj(postLoanList, searchDTO);

            //设置渠道商
            setChannelBusinessForObj(postLoanList, channelBusinessList, searchDTO);

            //设置逾期金额和天数
            setOverDueMoneyForObj(postLoanList, searchDTO);
        }

        return r.put("page", pager);
    }

    /**
     * 设置跟踪人
     * @param postLoanDTOList
     * @param searchDTO
     */
    private void setTrackerForObj(List<PostLoanDTO> postLoanDTOList, PostLoanSearchDTO searchDTO) {
        if (StringUtils.isNotBlank(searchDTO.getTrackerName())) {
            //搜索条件包含跟踪人则直接用条件赋值
            postLoanDTOList.forEach(postLoanDTO -> postLoanDTO.setTrackerName(searchDTO.getTrackerName()));
        } else {
            Set<Long> trackerIdSet = new HashSet<>();
            postLoanDTOList.forEach(postLoanDTO -> {
                if (postLoanDTO.getTrackerId() != null) {
                    trackerIdSet.add(postLoanDTO.getTrackerId());
                }
            });

            if (trackerIdSet.isEmpty()) {
                return ;
            }
            Map<String, Object> paramsMap = new HashedMap();
            paramsMap.put("userIds", trackerIdSet);
            paramsMap.put("simple", "y");
            List<SysUserEntity> sysUserEntityList = sysUserService.queryList(paramsMap);
            if (sysUserEntityList == null || sysUserEntityList.isEmpty()) {
                return ;
            }
            postLoanDTOList.forEach(postLoanDTO -> {
                if (postLoanDTO.getTrackerId() != null) {
                    for (SysUserEntity sysUserEntity : sysUserEntityList) {
                        if (sysUserEntity.getUserId() == postLoanDTO.getTrackerId()) {
                            postLoanDTO.setTrackerName(sysUserEntity.getNickname());
                            break;
                        }
                    }
                }
            });
        }
    }

    /**
     * 设置注册渠道
     * @param postLoanDTOList       结果列表
     * @param channelBusinessList   渠道列表
     * @param searchDTO             搜索条件
     */
    private void setChannelBusinessForObj(List<PostLoanDTO> postLoanDTOList, List<ChannelBusiness> channelBusinessList, PostLoanSearchDTO searchDTO) {
        if (channelBusinessList == null || channelBusinessList.isEmpty()) {
            return ;
        }
        if (searchDTO.getChannelId() != null && searchDTO.getChannelId() > 0) {
            //搜索条件包含渠道则直接用条件赋值
            for (ChannelBusiness channelBusiness : channelBusinessList) {
                if (searchDTO.getChannelId() == channelBusiness.getChannelId()) {
                    postLoanDTOList.forEach(postLoanDTO -> postLoanDTO.setChannelName(channelBusiness.getChannelName()));
                    break;
                }
            }
        } else {
            postLoanDTOList.forEach(postLoanDTO -> {
                for (ChannelBusiness channelBusiness : channelBusinessList) {
                    if (postLoanDTO.getChannelId() == channelBusiness.getChannelId()) {
                        postLoanDTO.setChannelName(channelBusiness.getChannelName());
                        break;
                    }
                }
            });
        }
    }

    /**
     * 设置逾期金额和逾期天数
     * @param postLoanDTOList
     * @param searchDTO
     */
    private void setOverDueMoneyForObj(List<PostLoanDTO> postLoanDTOList, PostLoanSearchDTO searchDTO) {
        Set<String> borrowIds = new HashSet<>();
        boolean isSearchOverDue = searchDTO.getStatus() != null && (BorrowInfoStatusEnum.OVERDUE.getKey() == searchDTO.getStatus()
                || BorrowInfoStatusEnum.SERIOUS_OVERDUE.getKey() == searchDTO.getStatus());
        LocalDate today = LocalDate.now();
        postLoanDTOList.forEach(postLoanDTO -> {
            if (isSearchOverDue || BorrowInfoStatusEnum.OVERDUE.getKey() == postLoanDTO.getStatus()
                    || BorrowInfoStatusEnum.SERIOUS_OVERDUE.getKey() == postLoanDTO.getStatus()) {
                borrowIds.add(postLoanDTO.getBorrowId());
                postLoanDTO.setOverDueDays((int)(today.toEpochDay() - postLoanDTO.getCycDate().toEpochDay()));
            }
        });

        if (borrowIds.isEmpty()) {
            return ;
        }
        Map paramsMap = new HashedMap();
        paramsMap.put("borrowIds", borrowIds);
        List<OverDueRecord> overDueRecords = overDueRecordService.list(paramsMap);
        if (overDueRecords == null || overDueRecords.isEmpty()) {
            return ;
        }
        postLoanDTOList.forEach(postLoanDTO -> {
            for (OverDueRecord overDueRecord : overDueRecords) {
                if (postLoanDTO.getBorrowId() == overDueRecord.getBorrowId()) {
                    if (overDueRecord.getCost() != null) {
                        postLoanDTO.setCost(overDueRecord.getCost());
                    }
                    if (overDueRecord.getPenaltyAmount() != null) {
                        postLoanDTO.setPenaltyAmount(overDueRecord.getPenaltyAmount());
                    }
                }
            }
        });
    }
}
