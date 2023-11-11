package com.taxplus.taxplusbackend.utils;

import com.alibaba.fastjson.JSON;
import com.qcloud.cos.COSClient;
import com.taxplus.taxplusbackend.secret.SecretMsg;
import com.tencentcloudapi.common.Credential;
import com.tencentcloudapi.common.profile.ClientProfile;
import com.tencentcloudapi.common.profile.HttpProfile;
import com.tencentcloudapi.common.exception.TencentCloudSDKException;
import com.tencentcloudapi.vod.v20180717.VodClient;
import com.tencentcloudapi.vod.v20180717.models.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Slf4j
@Component
public class TcMetaData {
    public String getMediaData(String file_id) {
        try {
            // 实例化一个认证对象，入参需要传入腾讯云账户 SecretId 和 SecretKey，此处还需注意密钥对的保密
            // 代码泄露可能会导致 SecretId 和 SecretKey 泄露，并威胁账号下所有资源的安全性。以下代码示例仅供参考，建议采用更安全的方式来使用密钥，请参见：https://cloud.tencent.com/document/product/1278/85305
            // 密钥可前往官网控制台 https://console.cloud.tencent.com/cam/capi 进行获取
            Credential cred = new Credential(SecretMsg.SecretId, SecretMsg.SecretKey);
            // 实例化一个http选项，可选的，没有特殊需求可以跳过
            HttpProfile httpProfile = new HttpProfile();
            httpProfile.setEndpoint("vod.tencentcloudapi.com");
            // 实例化一个client选项，可选的，没有特殊需求可以跳过
            ClientProfile clientProfile = new ClientProfile();
            clientProfile.setHttpProfile(httpProfile);
            // 实例化要请求产品的client对象,clientProfile是可选的
            VodClient client = new VodClient(cred, "", clientProfile);
            // 实例化一个请求对象,每个接口都会对应一个request对象
            DescribeMediaInfosRequest req = new DescribeMediaInfosRequest();
//            String[] fileIds1 = {"3270835011995499817"};
            String[] fileIds1 = {file_id};
            log.info(Arrays.toString(fileIds1));

            req.setFileIds(fileIds1);

            String[] filters1 = {"metaData"};
            req.setFilters(filters1);

            // 返回的resp是一个DescribeMediaInfosResponse的实例，与请求对象对应
            DescribeMediaInfosResponse resp = client.DescribeMediaInfos(req);
            // 输出json格式的字符串回包
            System.out.println(DescribeMediaInfosResponse.toJsonString(resp));
            return DescribeMediaInfosResponse.toJsonString(resp);

        } catch (
                TencentCloudSDKException e) {
            System.out.println(e.toString());
        }
        return null;
    }
}