package cn.tdw.service;


import cn.tdw.modules.oss.cloud.AliyunOssConfig;
import cn.tdw.modules.oss.cloud.AliyunOssService;

import com.aliyun.oss.OSSClient;
import com.aliyun.oss.model.OSSObject;
import com.aliyuncs.sts.model.v20150401.AssumeRoleResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StreamUtils;

import java.io.InputStream;
import java.nio.charset.Charset;

/**
 * Created by junte on 2017/8/28.
 */
@Service
public class PhoneContactsInfoServer {
 Logger logger= LoggerFactory.getLogger(PhoneContactsInfoServer.class);
    @Autowired
    AliyunOssService aliyunOssService;
    @Autowired
    AliyunOssConfig aliyunOssConfig;

    public String downloadUserPhoneContactsInfoFromAliServer(String uploadKey) {
        OSSClient ossClient = null;
        String data=null;
        try {
            AssumeRoleResponse response = aliyunOssService.assumeRole("quickLoan", false, true);
            String endpoint = aliyunOssConfig.getEndPoint();
            String bucket = aliyunOssConfig.getBucket();
            String accessKeyId = response.getCredentials().getAccessKeyId();
            String accessKeySecret = response.getCredentials().getAccessKeySecret();
            String securityToken = response.getCredentials().getSecurityToken();

            ossClient = new OSSClient(endpoint, accessKeyId, accessKeySecret, securityToken);

            OSSObject ossObject = ossClient.getObject(bucket, uploadKey);
            InputStream stream = ossObject.getObjectContent();
            data = StreamUtils.copyToString(stream, Charset.forName("UTF-8"));

            logger.info(data);
            if (StringUtils.isNotBlank(data)) {
               //asyncResult = new AsyncResult<String>(data);
            }
        } catch (Exception e) {//
            //LOGGER.error("从阿里服务器下载通讯录信息失败", e);
        } finally {
            // 关闭client
            ossClient.shutdown();
        }
        return  data;
    }
}
