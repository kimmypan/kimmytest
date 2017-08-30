package cn.tdw.controller;

import cn.tdw.common.exception.RRException;
import cn.tdw.common.utils.R;
import cn.tdw.domain.*;
import cn.tdw.dto.CollectionRecordDTO;
import cn.tdw.service.SignPartiCularsService;
import cn.tdw.util.ListPageUtil;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * Created by huangzhenwei on 2017/8/16.
 */

@RestController
@RequestMapping("manager/signDetails")
public class SignPartiCularsController {
    Logger logger = LoggerFactory.getLogger(SignPartiCularsService.class);
    @Autowired
    private SignPartiCularsService service;
    /***
     * 返回用户基础信息
     * @param userId  获取用户ID
     * @return
     */
    @RequestMapping(value = "/userDetails")
    public R getUserDetails(@RequestParam("userId") String userId) {
        if (StringUtils.isEmpty(userId)) {
            throw new RRException("用户ID不能为空");
        }
        UserBasicInfo userBasicInfo = service.getUserBasicInfo(userId);
        return R.ok().put("userBasicInfo", userBasicInfo);
    }

    /**
     * 查看借款详情
     *
     * @param userId   获取用户ID
     * @param borrowId 获取借款编号ID
     * @return
     */
    @RequestMapping(value = "/borrowInfo")
    public R getBorrowInfo(@RequestParam("userId") String userId, @RequestParam("borrowId") String borrowId) {
        if (StringUtils.isEmpty(userId) && StringUtils.isEmpty(borrowId)) {
            throw new RRException("用户ID和借款编号ID不能为空");
        }
        BorrowInfo borrowInfo = service.getSelectBorrowInfo(userId, borrowId);

        return R.ok().put("borrowDetail", borrowInfo);
    }

    /***
     *
     * 查询紧急联系人
     * @param userId 获取用户ID
     * @return
     */
    @RequestMapping(value = "/contact", method = RequestMethod.POST)
    public R getContact(@RequestParam("userId") String userId) {
        if (StringUtils.isEmpty(userId)) {
            throw new RRException("用户ID不能为空");
        }
        List<EmergencyContact> emergencyContact = service.getEmergencyContact(userId);
        return R.ok().put("emergencyContact", emergencyContact);

    }

    /***
     * 查询催收记录
     * @param userId
     * @return
     */
    @RequestMapping(value = "/record", method = RequestMethod.POST)
    public R getRecord(@RequestParam("userId") String userId) {
        if (StringUtils.isEmpty(userId)) {
            throw new RRException("用户ID不能为空");
        }
        List<CollectionRecord> getcollectrecord = service.getCollectRecord(userId);
        return R.ok().put("collectRecord", getcollectrecord);
    }

 /*   *//**
     * 用户信息拓展(查看身份证)
     *//*
    @RequestMapping(value = "identityCard")
    public R UserInfoExt(@Param("userId") String userId) {
        UserBasicInfoExt userBasicInfoExt = service.getSelecUserInfoExt(userId);
        return R.ok().put("userBasicInfoExt", userBasicInfoExt);
    }
*/

    /***
     * 增加催收记录
     * @param
     * @return
     */
    @RequestMapping("insertrecord")
    public R getinsertrecord(@RequestParam("collectionInfo") String collectionInfo, @RequestParam("borrowId") String borrowId, @RequestParam("userId") String userId) {
        if (StringUtils.isEmpty(collectionInfo) && StringUtils.isEmpty(borrowId)) {
            throw new RRException("催收情况内容和borrowId不能为空");
        }
        CollectionRecordDTO dto = new CollectionRecordDTO();
        dto.setUserId(userId);
        dto.setBorrowId(borrowId);
        dto.setCollectionInfo(collectionInfo);
        service.getInsertCollectRecord(dto);
        //添加成功，返回Y
        return R.ok("Y");
    }

    /**
     * 天秤反欺诈（查看详情）
     *
     * @param userId
     * @return
     */
    @RequestMapping("ApiDate")
    public R getApidate(@RequestParam("userId") String userId) {
        ApiData apiDate = service.getApiDate(userId);
        return R.ok().put("apiDate", apiDate);
    }

    /**
     * 新增公告板
     *
     * @param borrowId
     * @param announcement
     * @return
     */
    @RequestMapping(value = "bulletinSave")
    public R upBulletin(@RequestParam("borrowId") String borrowId, @RequestParam("announcement") String announcement) {
        if (StringUtils.isEmpty(borrowId)) {
            throw new RRException("userId不能为空");
        }
        //判断页面获取的数据超过255，抛异常
        int length = 0;
        for (int i = 0; i < announcement.length(); i++) {
            int ascii = Character.codePointAt(announcement, i);
            if (ascii >= 0 && ascii <= 255)
                length++;
            else
                length += 2;
        }
        if (length > 255) {
            throw new RRException("数据有误，长度不能大于255");
        } else {
            service.inBulletin(announcement, borrowId);
            return R.ok("Y");

        }
    }
    /**
     * 通讯录详情
     *
     * @param userId
     * @return
     */
    @RequestMapping(value = "phoneDetail")
    public R getPhoneContact(@RequestParam("userId") String userId,@RequestParam(value = "pageIndex",defaultValue ="1")Integer pageIndex) {
        if (StringUtils.isEmpty(userId)) {
            throw new RRException("userId不能为空");
        }
        List<ContactListDetailSimple> contactListDetailSimpleList = service.findByPhoneContact(userId);
        Integer pagecount =contactListDetailSimpleList.size();
        Integer page= (int)Math.ceil((double)pagecount/(double)5);
        logger.info(""+page);
        ContactListDetailSimple contactListDetailSimple=new ContactListDetailSimple();
        contactListDetailSimple.setPage(page);
        ListPageUtil<ContactListDetailSimple> listPageUtil = new ListPageUtil<ContactListDetailSimple>(contactListDetailSimpleList,pageIndex, 5);
        List<ContactListDetailSimple> pagedList = listPageUtil.getPagedList();
        logger.info(""+pagedList);
        return R.ok().put("SimpleList",pagedList);
    }
    /**
     * 通话记录详情
     * @param userId
     * @return
     */
    @RequestMapping(value = "callDetail")
    public R  getPhoneDetail(@RequestParam("userId") String userId) {
        if (StringUtils.isEmpty(userId)) {
            throw new RRException("userId不能为空");
        }
        List<CallContactDetailSimple> callContactDetailSimples=service.getPhoneDetail(userId);
        return R.ok().put("callSimples",callContactDetailSimples);
    }

}
