package cn.tdw.service;

import cn.tdw.QuickLoanManagerApplicationTests;
import cn.tdw.domain.BorrowInfo;
import cn.tdw.domain.EmergencyContact;
import cn.tdw.domain.UserBasicInfo;
import cn.tdw.modules.oss.cloud.AliyunOssService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.math.BigDecimal;
import java.net.URL;
import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.util.List;

/**
 * Created by huangzhenwei on 2017/8/25.
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SignPartiCularsTest {

    Logger logger= LoggerFactory.getLogger(QuickLoanManagerApplicationTests.class);
    @Autowired
    SignPartiCularsService userBasicInfoService;
    @Autowired
    private AliyunOssService aliyunOssService;//获取身份证地址;
    @Autowired
    PhoneContactsInfoServer phoneContactsInfoServer;

    /**
     * 基础信息查询信息测试
     */
    @Test
    public void demo1(){
        String userId="9b191d67-7a55-11e7-b6df-0050568f7fba";
        UserBasicInfo getuserbasicinfo = userBasicInfoService.getUserBasicInfo(userId);
        logger.info("返回结果集为："+getuserbasicinfo.getAge());
    }


    /**借款记录*/
    @Test
    public void demo2(){
        String userId="91ED99CAE1D04B4B91D9352950085A2F";
        String borrowId="B500F85B05C34016872F97269F6E26CD";
        BorrowInfo borrowInfo= userBasicInfoService.getSelectBorrowInfo(userId,borrowId);
        logger.info("返回结果集=================》"+borrowInfo);
    }
    @Test
    public void demo3(){
        //逾期天数计算
        LocalDate localDate= LocalDate.parse("2017-08-15");
        logger.info("还款时间===========》"+localDate );
        LocalDate nowtime=localDate.now();
        logger.info("当前时间===========》"+nowtime);
        long until = localDate.until(nowtime, ChronoUnit.YEARS);

        System.out.print("逾期天数====》"+until);


    }
    //紧急联系人
    @Test
    public void demo4(){
        String userId="DF3E84E5827F4D1ABE054BDDEE541567";
        List<EmergencyContact> emergencyContacts= userBasicInfoService.getEmergencyContact(userId);
        logger.info("返回数据==============》"+emergencyContacts);

    }


    //调用阿里云接口获取url
    @Test
    public void demo5(){
        URL quickloantest = aliyunOssService.createAccessLink("quickloantest", "274D2D4C-BC11-4E64-854D-688A3BD95CB4front", 600);
        logger.info(""+quickloantest);
    }


    @Test
    public void demo6(){
        double a=0.921786;
        double v = a * 100;
        BigDecimal b   =   new BigDecimal(v);
        int i=b.setScale(2,   BigDecimal.ROUND_HALF_UP).intValue();
        System.out.print(i);

    }
    //天秤jsonlist转对象
    @Test
    public void demo7(){

        String userId="921060b1-caf7-4dd1-8008-b2d48c196ea8";
        userBasicInfoService.getApiDate(userId);

    }
@Test

    public void demo8(){
    String s = phoneContactsInfoServer.downloadUserPhoneContactsInfoFromAliServer("0646FF6E-C462-43DF-A18C-F96C520F06F2");
    logger.info(s);
}

@Test
    public void demo9(){
        userBasicInfoService.getPhoneDetail("085C388C374A4C70B58C5BAE8426729F");

}
}
