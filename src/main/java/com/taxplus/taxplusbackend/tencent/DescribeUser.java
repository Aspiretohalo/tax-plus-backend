package com.taxplus.taxplusbackend.tencent;

import com.taxplus.taxplusbackend.secret.SecretMsg;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.lcic.v20220817.LcicClient;
import com.tencentcloudapi.lcic.v20220817.models.*;
import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DescribeUser {
    static String secretId = SecretMsg.SecretId;
    static String secretKey = SecretMsg.SecretKey;

    public static void main(String[] args) {
        try {
            // 实例化一个认证对象，入参需要传入腾讯云账户 SecretId 和 SecretKey，此处还需注意密钥对的保密
            // 代码泄露可能会导致 SecretId 和 SecretKey 泄露，并威胁账号下所有资源的安全性。以下代码示例仅供参考，建议采用更安全的方式来使用密钥，请参见：https://cloud.tencent.com/document/product/1278/85305
            // 密钥可前往官网控制台 https://console.cloud.tencent.com/cam/capi 进行获取
            Credential cred = new Credential(secretId, secretKey);
            // 实例化一个http选项，可选的，没有特殊需求可以跳过
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("lcic.tencentcloudapi.com");
            // 实例化一个client选项，可选的，没有特殊需求可以跳过
            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);
            // 实例化要请求产品的client对象,clientProfile是可选的
            LcicClient client = new LcicClient(cred, "", clientProfile);
            // 实例化一个请求对象,每个接口都会对应一个request对象
            DescribeUserRequest req = new DescribeUserRequest();
            req.setUserId("2WqAZwoikxV6SEmJGHpe5h9K3wc");
            // 返回的resp是一个DescribeUserResponse的实例，与请求对象对应
            DescribeUserResponse resp = client.DescribeUser(req);
            // 输出json格式的字符串回包
            System.out.println(DescribeUserResponse.toJsonString(resp));
        } catch (TencentCloudSDKException e) {
            System.out.println(e.toString());
        }
    }
}
