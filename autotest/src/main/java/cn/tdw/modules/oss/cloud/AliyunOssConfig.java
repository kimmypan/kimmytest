package cn.tdw.modules.oss.cloud;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

/**
 * Created by dami on 2017/08/08.
 */
@Configuration
@ConfigurationProperties(prefix="loan.config.oss.aliyun")
public class AliyunOssConfig {

    private String region;
    private String apiVersion;
    private String accessKeyId;
    private String accessKeySecret;
    private String roleArn;
    private String writeReadPolicy;
    private String readPolicy;
    private String netAccessUrl;
    private Long validSecond;
    private String bucket;
    private String endPoint;


    public String getRegion() {
        return region;
    }

    public String getApiVersion() {
        return apiVersion;
    }

    public String getAccessKeyId() {
        return accessKeyId;
    }

    public String getAccessKeySecret() {
        return accessKeySecret;
    }

    public String getRoleArn() {
        return roleArn;
    }

    public String getWriteReadPolicy() {
        return writeReadPolicy;
    }

    public String getReadPolicy() {
        return readPolicy;
    }


    public AliyunOssConfig setRegion(String region) {
        this.region = region;
        return this;
    }

    public AliyunOssConfig setApiVersion(String apiVersion) {
        this.apiVersion = apiVersion;
        return this;
    }

    public AliyunOssConfig setAccessKeyId(String accessKeyId) {
        this.accessKeyId = accessKeyId;
        return this;
    }

    public AliyunOssConfig setAccessKeySecret(String accessKeySecret) {
        this.accessKeySecret = accessKeySecret;
        return this;
    }

    public AliyunOssConfig setRoleArn(String roleArn) {
        this.roleArn = roleArn;
        return this;
    }

    public AliyunOssConfig setWriteReadPolicy(String writeReadPolicy) {
        this.writeReadPolicy = writeReadPolicy;
        return this;
    }

    public AliyunOssConfig setReadPolicy(String readPolicy) {
        this.readPolicy = readPolicy;
        return this;
    }

    public String getNetAccessUrl() {
        return netAccessUrl;
    }

    public AliyunOssConfig setNetAccessUrl(String netAccessUrl) {
        this.netAccessUrl = netAccessUrl;
        return this;
    }

    public Long getValidSecond() {
        return validSecond;
    }

    public AliyunOssConfig setValidSecond(Long validSecond) {
        this.validSecond = validSecond;
        return this;
    }

    public String getBucket() {
        return bucket;
    }

    public AliyunOssConfig setBucket(String bucket) {
        this.bucket = bucket;
        return this;
    }

    public String getEndPoint() {
        return endPoint;
    }

    public AliyunOssConfig setEndPoint(String endPoint) {
        this.endPoint = endPoint;
        return this;
    }

    @Override
    public String toString() {
        return "AliyunOssConfig{" +
                "region='" + region + '\'' +
                ", apiVersion='" + apiVersion + '\'' +
                ", accessKeyId='" + accessKeyId + '\'' +
                ", accessKeySecret='" + accessKeySecret + '\'' +
                ", roleArn='" + roleArn + '\'' +
                ", writeReadPolicy='" + writeReadPolicy + '\'' +
                ", readPolicy='" + readPolicy + '\'' +
                ", netAccessUrl='" + netAccessUrl + '\'' +
                ", validSecond=" + validSecond +
                ", bucket='" + bucket + '\'' +
                ", endPoint='" + endPoint + '\'' +
                '}';
    }
}
