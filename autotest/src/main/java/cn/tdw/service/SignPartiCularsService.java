package cn.tdw.service;

import cn.tdw.common.exception.RRException;
import cn.tdw.dao.*;
import cn.tdw.domain.*;
import cn.tdw.domain.ContactListDetailSimple;
import cn.tdw.domain.phonecontact.*;
import cn.tdw.dto.CollectionRecordDTO;
import cn.tdw.modules.oss.cloud.AliyunOssService;
import com.alibaba.fastjson.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;


/**
 * Created by huangzhenwei on 2017/8/14.
 */
@Service
public class SignPartiCularsService {
    Logger logger = LoggerFactory.getLogger(SignPartiCularsService.class);
    @Autowired
    private UserBasicInfoDAO userBasicInfoDAO;//用户基础信息
    @Autowired
    private BorrowInfoDAO borrowInfoDao; //借款记录
    @Autowired
    private EmergencyContactDAO emergencyContactDAO;//紧急联系人
    @Autowired
    private CollectionRecordDAO ccollectionRecordDAO;//催收记录
    @Autowired
    private UserBasicInfoExtDAO userBasicInfoExtDAO;//用户信息拓展
    @Autowired
    private ApiDataDAO apiDataDAO;//天秤接口
    @Autowired
    private AliyunOssService aliyunOssService;//获取身份证地址
    @Autowired
    private CreditManagementDAO creditManagementDAO;//获取身份证状态和活体认证及分数
    @Autowired
    private PhoneContactsDAO phoneContactsDAO;//通讯录
    @Autowired
    private PhoneContactsInfoServer phoneContactsInfoServer;//获取通讯录通讯详情数据接口


    /**
     * 获取用户基础信息
     *
     * @param userId 通过用户编号获取
     * @return
     */
    public UserBasicInfo getUserBasicInfo(String userId) {
        UserBasicInfo userBasicInfo = userBasicInfoDAO.seluserbasicinfo(userId);
        if(userBasicInfo !=null){
            //计算可用额度（信用额度-已用额度）
            userBasicInfo.setUsableAmount(userBasicInfo.getCreditAmount() - userBasicInfo.getUsedCreditAmount());
            //调接口获取芝麻分
        //计算用户年龄
        if (userBasicInfo.getBirthdate() != null) {
            long userage = userBasicInfo.getBirthdate().until(LocalDate.now(), ChronoUnit.YEARS);
            if (userage > 0) {
                userBasicInfo.setAge(userage);
            } else {
                throw new RRException("获取生日参数有误");
            }
        }
            //获取实名认证，活体认证状态和分数
            CreditManagement creditManagement = selCreManage(userId);
            //获取活体认证分数
            userBasicInfo.setIdentityState(creditManagement != null ? creditManagement.getIdentityState() : null);

            //保留2位小数计算分数值
            BigDecimal b = new BigDecimal(creditManagement != null && creditManagement.getVerifyScore() != null ? (creditManagement.getVerifyScore() * 100) : 0);
            userBasicInfo.setVerifyScore(creditManagement != null ? b.setScale(2, BigDecimal.ROUND_HALF_UP).intValue() : null);
        }
        ApiData apiDate = getApiDate(userId);
        if (!StringUtils.isEmpty(apiDate.getZmscore())) {
            userBasicInfo.setZmscore(apiDate.getZmscore());
        }
        //调用方法获取身份证地址
        UserBasicInfoExt infoExt = userBasicInfoExtDAO.SelecUserInfoExt(userId);
        //获取正面身份证地址
        if (infoExt != null && !StringUtils.isEmpty(infoExt.getFrontCardBucket()) && !StringUtils.isEmpty(infoExt.getFrontCardObjectId())) {
            userBasicInfo.setFrontCard_url(aliyunOssService.createAccessLink(infoExt.getFrontCardBucket(), infoExt.getFrontCardObjectId(), 600).toString());
        }
        //获取反面身份证地址
        if (infoExt != null && !StringUtils.isEmpty(infoExt.getBackCardBucket()) && !StringUtils.isEmpty(infoExt.getBackCardObjectId())) {
            userBasicInfo.setBackCard_url(aliyunOssService.createAccessLink(infoExt.getBackCardBucket(), infoExt.getBackCardObjectId(), 600).toString());
        }
        if (infoExt != null && !StringUtils.isEmpty(infoExt.getLivenessBucket()) && !StringUtils.isEmpty(infoExt.getFrontCardObjectId())) {
            //获取活体视频地址
            userBasicInfo.setLiveVideo_url(aliyunOssService.createAccessLink(infoExt.getLivenessBucket(), infoExt.getLivenessObjectId(), 600).toString());
        }


        return userBasicInfo;
    }

    /***
     * 借款记录表
     * @param userId 传入的用户ID
     * @param borrowId 传入借款编号ID
     * @return
     */
    public BorrowInfo getSelectBorrowInfo(String userId, String borrowId) {
        BorrowInfo borrowInfo = borrowInfoDao.selectBorrowInfo(userId, borrowId);
        logger.info("返回结果集:====》" + borrowInfo);
        //逾期天数计算（实际还款与当前时间差单位/天）
        long day = borrowInfo.getCycDate().until(LocalDate.now(), ChronoUnit.DAYS);
        if (day > 0) {
            borrowInfo.setDay(day);
        }
        borrowInfo.setBorrowId(borrowId);
        borrowInfo.setUserId(userId);
        //借款利率计算(团贷费率+信息费率+担保费率)
        if(borrowInfo.getGuaranteRate()!=null||borrowInfo.getTuandaiRate()!=null||borrowInfo.getMessageRate()!=null){
            int a = borrowInfo.getGuaranteRate() + borrowInfo.getTuandaiRate() + borrowInfo.getMessageRate();
            borrowInfo.setLendingrate((double) a / 10000);
        }
        //计算服务费(团贷服务费+信息服务费+担保服务费)
        borrowInfo.setServicecharge(borrowInfo.getTuandaiAmount() + borrowInfo.getMessageAmount() + borrowInfo.getGuaranteAmount());
        //应还金额
        borrowInfo.setActualamount(borrowInfo.getAmount());
        //实际还款时间转为日
        if (borrowInfo.getCreateDate() != null) {
            borrowInfo.setRealityDate(borrowInfo.getCreateDate().toLocalDate());
        }
        return borrowInfo;
    }

    /***
     * 获取紧急联系人信息
     * @param userId 传入ID
     * @return
     */
    public List<EmergencyContact> getEmergencyContact(String userId) {
        List<EmergencyContact> emergencyContact = emergencyContactDAO.selemergencycontact(userId);
        logger.info("紧急联系人结果集=====》" + emergencyContact);
        return emergencyContact;
    }

    /**
     * 查看催收记录
     *
     * @param userId
     * @return
     */
    public List<CollectionRecord> getCollectRecord(String userId) {
        List<CollectionRecord> ccollectionRecord = ccollectionRecordDAO.collectRecord(userId);
        for (CollectionRecord c : ccollectionRecord) {
            if (c.getCreateTime() != null) {
                c.setCreateDate(c.getCreateTime().toLocalDate());
            }
        }
        logger.info("催收记录结果集=============》" + ccollectionRecord);
        return ccollectionRecord;
    }

    /***
     * 新增催收记录
     * @param
     */
    public void getInsertCollectRecord(CollectionRecordDTO dto) {
        CollectionRecord record = new CollectionRecord();
        record.setCollectionInfo(dto.getCollectionInfo());
        record.setBorrowId(dto.getBorrowId());
        if (ccollectionRecordDAO.insertCollectRecord(record) < 0) {
            throw new RRException("数据异常，报错失败");
        } else {
            ccollectionRecordDAO.collectRecord(dto.getUserId());
        }
    }

    /**
     * 获取天秤反欺诈系统接口数据
     *
     * @param userId
     * @return
     */
    public ApiData getApiDate(String userId) {
        ApiData data = new ApiData();
        //年龄检测
        UserBasicInfo userBasicInfo = userBasicInfoDAO.seluserbasicinfo(userId);
        if(userBasicInfo !=null){
            if (userBasicInfo.getBirthdate() != null) {
                Long userage = userBasicInfo.getBirthdate().until(LocalDate.now(), ChronoUnit.YEARS);
                //获取用户年龄判断用户年龄是否超过18岁，说明（age>18）
                data.setAge(userage);
            }
        }
        //返回全部需要检查的接口数据
        List<ApiData> apilist = apiDataDAO.apiDataList(userId);
        JSONArray json = new JSONArray();
        for (ApiData data1 : apilist) {
            //百融多次申请核查
         /*   if(data.getFunctionCode().equals("10006003")){
                JSONObject jsonObject = JSONObject.fromObject(data1.getResponseBusiData());
                String applyloanstr = jsonObject.getJSONArray("Flag").getJSONObject(0).getString("applyloanstr");
                //根据产品输出标识进行判断 1（输出成功）0（未匹配上无输出）99（系统异常），null(没有选择该报告或输入信息不充足)
                data.setApplyloanstr(applyloanstr);
            }*/
            //百融特殊名单
          /*  if (data1.getFunctionCode().equals("10006002")) {
                JSONObject jsonObject = JSONObject.fromObject(data1.getResponseBusiData());
                String specialList_c = jsonObject.getJSONArray("Flag").getJSONObject(0).getString("SpecialList_c");
                //根据产品输出标识进行判断 1（输出成功）0（未匹配上无输出）99（系统异常），null(没有选择该报告或输入信息不充足)
                data.setSpecialList_c(specialList_c);
            }*/
            //考拉黑名单
            if (data1.getFunctionCode().equals("10017001")) {
                JSONObject jsonObject = JSONObject.fromObject(data1.getResponseBusiData());
                String result = jsonObject.getString("result");
                //根据返回的状态码1（有数据）2（无数据）
                data.setBack_h(result);
            }
            //考拉手机号实名
            if (data1.getFunctionCode().equals("10017002")) {
                JSONObject jsonObject = JSONObject.fromObject(data1.getResponseBusiData());
                String result = jsonObject.getString("result");
                //根据返回的T（通过）、F（不通过）、N（无记录）
                data.setPhone_result(result);
            }
            //手机时长（没有提供）
            if (data1.getFunctionCode().equals("10017002")) {
                JSONObject jsonObject = JSONObject.fromObject(data1.getResponseBusiData());
                String result = jsonObject.getString("result");
                //根据返回的 ABCEFGHZ来判断时长是多少
                data.setPhone_result(result);
            }
            //前海征信黑名单
            if (data1.getFunctionCode().equals("10011002")) {
                JSONObject jsonObject = JSONObject.fromObject(data1.getResponseBusiData());
                String erCode = jsonObject.getJSONArray("busiData").getJSONObject(0).getString("erCode");
                //待确定
                data.setErCode(erCode);
            }
            //天秤网贷黑名单
            if (data1.getFunctionCode().equals("10013001")) {
                JSONObject jsonObject = JSONObject.fromObject(data1.getResponseBusiData());
                JSONArray datas = jsonObject.getJSONArray("datas");
                //通过返回的数据记录判断（无记录表示不存在，有记录表示存在）
                int datasize = datas.size();
                data.setDatas(datasize);
            }
            //天秤自有黑名单
            if (data1.getFunctionCode().equals("10013003")) {
                JSONObject jsonObject = JSONObject.fromObject(data1.getResponseBusiData());
                //返回：isbalcklist状态码（1表示在黑名单中0表示不再黑名单中）
                int isbalcklist = jsonObject.getJSONArray("datas").getJSONObject(0).getInt("isBlacklistUser");
                data.setSelfltit(isbalcklist);
            }
            //天秤老赖黑名单
          /*  if(data1.getFunctionCode().equals("10013002")){
                JSONObject jsonObject = JSONObject.fromObject(data1.getResponseBusiData());
                JSONArray datas = jsonObject.getJSONArray("datas");
                int deadbealdit=datas.size();
                data.setDeadbealfit(deadbealdit);
            }*/
            //芝麻分≥600分（暂时没提供）
            if (data1.getFunctionCode().equals("10010008")) {
                JSONObject jsonObject = JSONObject.fromObject(data1.getResponseBusiData());
                String zmscore = jsonObject.getString("zmScore");
                data.setZmscore(zmscore);
            }
            logger.info("返回的结果集" + apilist);
        }
        return data;
    }

    /**
     * 新增公告
     *
     * @param announcement
     */
    public void inBulletin(String announcement, String borrowId) {
        //修改公告
        borrowInfoDao.upBulletin(announcement, borrowId);
    }

    /**
     * 获取实名认证状态和活体视频认证及分数
     */
    public CreditManagement selCreManage(String userId) {
        CreditManagement creditManagement = creditManagementDAO.seleCreditManage(userId);
        return creditManagement;
    }

    /***
     * 获取通讯录接口数据
     * @param userId
     * @return
     */
    public  List<ContactListDetailSimple>  findByPhoneContact(String userId) {
        PhoneContacts phoneContact = phoneContactsDAO.findContact(userId);
       List<ContactListDetailSimple> contactListDetailSimpleList=new ArrayList<ContactListDetailSimple>();
        phoneContact.setCallRecordsAnalyzePath("35FA74CA-73C9-41B0-B783-1AE259D29306");
        //通话记录详情
        String data = phoneContactsInfoServer.downloadUserPhoneContactsInfoFromAliServer(phoneContact.getCallRecordsAnalyzePath());
        JSONObject temp = JSONObject.fromObject(JSON.parseObject(data));
        JSONObject phonedetailObj = temp.getJSONObject("msgBody");
        JSONArray contactListDetail = phonedetailObj.getJSONArray("contactListDetail");
        List<ContactListDetail> contactDetailList = JSON.parseArray(contactListDetail.toString(), ContactListDetail.class);
        for (ContactListDetail i:contactDetailList){
            List<ContactListPhoneDetail> details = i.getContactListPhoneDetail();
            for (ContactListPhoneDetail j:details) {
                ContactListDetailSimple simple = new ContactListDetailSimple(j);
                simple.setMatchPhones(i.getMatchPhones());
                simple.setUpdateTime(i.getUpdateTime());
                contactListDetailSimpleList.add(simple);
            }
        }
        return contactListDetailSimpleList;
}

    /**
     * 通话记录接口
     * @return
     */
    public List<CallContactDetailSimple> getPhoneDetail(String userId) {
        PhoneContacts phoneContact = phoneContactsDAO.findContact(userId);
        phoneContact.setCallRecordsAnalyzePath("35FA74CA-73C9-41B0-B783-1AE259D29306");
        List<CallContactDetailSimple> callContactDetailSimples = new ArrayList<CallContactDetailSimple>();
        String dataPhone = phoneContactsInfoServer.downloadUserPhoneContactsInfoFromAliServer(phoneContact.getCallRecordsAnalyzePath());
        JSONObject temp = JSONObject.fromObject(JSON.parseObject(dataPhone));
        JSONObject phonedetailObj = temp.getJSONObject("msgBody");
        JSONObject callinfo=phonedetailObj.getJSONObject("callInfo");

        JSONArray callHistory=callinfo.getJSONArray("callHistory");
        List<CallHistory> callHistories = JSON.parseArray(callHistory.toString(), CallHistory.class);
        SimpleDateFormat sd = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
        for (CallHistory call:callHistories) {
            List<CallPlaces> callPlaces=call.getCallPlaces();
            for (CallPlaces palce :callPlaces ){
                CallContactDetailSimple  callContactDetailSimple =new CallContactDetailSimple();
                callContactDetailSimple.setCallPlaces(palce.getPlaceName());
                callContactDetailSimple.setPlaceTimes(palce.getPlaceTimes());
                callContactDetailSimple.setPhone(call.getPhone());
                //callContactDetailSimple.setName(call.name);
                callContactDetailSimple.setPhonePlace(call.getPhonePlace());
                callContactDetailSimple.setConcactTimes(call.getConcactTimes());
                callContactDetailSimple.setCallTimes(call.getCallTimes());
                callContactDetailSimple.setCalledTimes(call.getCalledTimes());
                callContactDetailSimple.setTimeDuration(call.getTimeDuration());
                callContactDetailSimple.setFirstCallTime(call.getFirstCallTime());
                callContactDetailSimple.setLastCallTime(call.getLastCallTime());
                callContactDetailSimple.setIsCurrentOverdue(call.getIsCurrentOverdue());
                callContactDetailSimple.setIsIssueLoan(call.getIsIssueLoan());
                callContactDetailSimple.setIsNwUser(call.getIsNwUser());
                callContactDetailSimple.setIsOverdueRepay(call.getIsOverdueRepay());
                callContactDetailSimple.setIsRelationUser(call.getIsRelationUser());
                callContactDetailSimples.add(callContactDetailSimple);
                callContactDetailSimple.setValidCallNum(callinfo.getInt("validCallNum"));
                //callContactDetailSimple.setPlaceTimes();
            }
        }
        return callContactDetailSimples;
    }
}