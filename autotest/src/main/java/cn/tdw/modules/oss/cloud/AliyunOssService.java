package cn.tdw.modules.oss.cloud;
import cn.tdw.util.RandomUtil;
import com.aliyun.oss.OSSClient;

import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.http.ProtocolType;
import com.aliyuncs.profile.DefaultProfile;
import com.aliyuncs.profile.IClientProfile;
import com.aliyuncs.sts.model.v20150401.AssumeRoleRequest;
import com.aliyuncs.sts.model.v20150401.AssumeRoleResponse;
import org.apache.commons.lang3.time.DateUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

/**
 * Created by dami on 2017/08/08.
 */
@Service
public class AliyunOssService {

    private static final Logger logger = LoggerFactory.getLogger(AliyunOssService.class);

    @Autowired
    private AliyunOssConfig aliyunOssConfig;

    public AssumeRoleResponse assumeRole(String roleSessionName,boolean write,boolean read) throws ClientException {
        // 创建一个 Aliyun Acs Client, 用于发起 OpenAPI 请求
        IClientProfile profile = DefaultProfile.getProfile(aliyunOssConfig.getRegion(), aliyunOssConfig.getAccessKeyId(), aliyunOssConfig.getAccessKeySecret());
        DefaultAcsClient client = new DefaultAcsClient(profile);

        // 创建一个 AssumeRoleRequest 并设置请求参数
        final AssumeRoleRequest request = new AssumeRoleRequest();
        request.setVersion(aliyunOssConfig.getApiVersion());
        request.setMethod(MethodType.POST);
        request.setProtocol(ProtocolType.HTTPS);
        request.setDurationSeconds(aliyunOssConfig.getValidSecond().longValue());

        request.setRoleArn(aliyunOssConfig.getRoleArn());
        request.setRoleSessionName(roleSessionName);
        if(write){
            request.setPolicy(aliyunOssConfig.getWriteReadPolicy());
        }else if(read){
            request.setPolicy(aliyunOssConfig.getReadPolicy());
        }


        // 发起请求，并得到response
        final AssumeRoleResponse response = client.getAcsResponse(request);
        return response;
    }

    /**
     * 获取阿里云图片访问地址
     * @param bucket 阿里云bucket
     * @param objectId 文件id
     * @param expireSeconds 过期时间，单位秒
     * @return
     */
    public URL generationPhotoAccessLink(String bucket, String objectId, long expireSeconds){
        Date expireTime = DateUtils.addSeconds(new Date(), (int) expireSeconds);

        return this.generationPhotoAccessLink(bucket,objectId,expireTime);
    }

    /**
     * 获取阿里云图片访问地址
     * @param bucket 阿里云bucket
     * @param objectId 文件id
     * @param expireTime 过期时间
     * @return
     */
    public URL generationPhotoAccessLink(String bucket, String objectId, Date expireTime){
        OSSClient client = new OSSClient(aliyunOssConfig.getEndPoint(),aliyunOssConfig.getAccessKeyId(),aliyunOssConfig.getAccessKeySecret());
        return client.generatePresignedUrl(aliyunOssConfig.getBucket(),objectId,expireTime);
    }


    public URL createAccessLink(String bucket, String objectId, long expireSeconds) {

        String roleSessionName = new SimpleDateFormat("yyyyMMdd-").format(new Date())+ UUID.randomUUID().toString().hashCode()+"-"+ RandomUtil.getRandom(3);
        AssumeRoleResponse   response = null;
        try {
            response = this.assumeRole(roleSessionName, false, true);
        } catch (ClientException e) {
            logger.error("生成STS出错",e.getMessage());
        }

        OSSClient client = new OSSClient(aliyunOssConfig.getEndPoint(),response.getCredentials().getAccessKeyId(),response.getCredentials().getAccessKeySecret(),response.getCredentials().getSecurityToken());
        Date expires = new Date (new Date().getTime() + 1000 * expireSeconds);

        URL url = client.generatePresignedUrl(bucket,objectId,expires);
        logger.info("生成访问图片地址" + url.toString());
        return  url;
    }

    public String getNetAccessUrl(){
        return aliyunOssConfig.getNetAccessUrl();
    }

    public String getBucket(){
        return this.aliyunOssConfig.getBucket();
    }

    public String getEndPoint(){
        return this.aliyunOssConfig.getEndPoint();
    }
}