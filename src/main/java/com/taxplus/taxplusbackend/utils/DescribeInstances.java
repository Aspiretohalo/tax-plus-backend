package com.taxplus.taxplusbackend.utils;

import com.taxplus.taxplusbackend.secret.SecretMsg;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.cvm.v20170312.CvmClient;
import com.tencentcloudapi.cvm.v20170312.models.DescribeInstancesRequest;
import com.tencentcloudapi.cvm.v20170312.models.DescribeInstancesResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class DescribeInstances {
    static String secretId = SecretMsg.SecretId;
    static String secretKey = SecretMsg.SecretKey;

    public static void main(String[] args) {
        System.out.println(secretId);
        System.out.println(secretKey);
        try {
            // 为了保护密钥安全，建议将密钥设置在环境变量中或者配置文件中，请参考本文凭证管理章节。
            // 硬编码密钥到代码中有可能随代码泄露而暴露，有安全隐患，并不推荐。
            Credential cred = new Credential(secretId, secretKey);
//            Credential cred = new Credential(System.getenv(secretId), System.getenv(secretKey));
            CvmClient client = new CvmClient(cred, "ap-shanghai");

            DescribeInstancesRequest req = new DescribeInstancesRequest();
            DescribeInstancesResponse resp = client.DescribeInstances(req);

            System.out.println(DescribeInstancesResponse.toJsonString(resp));
        } catch (TencentCloudSDKException e) {
            log.info("腾讯云接口请求错误，错误信息：{}", e.toString());
        }
    }
}