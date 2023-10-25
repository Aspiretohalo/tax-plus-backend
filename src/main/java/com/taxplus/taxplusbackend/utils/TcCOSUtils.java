package com.taxplus.taxplusbackend.utils;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.http.HttpProtocol;
import com.qcloud.cos.model.GetObjectRequest;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.model.PutObjectResult;
import com.qcloud.cos.region.Region;
import com.qcloud.cos.transfer.Download;
import com.qcloud.cos.transfer.TransferManager;
import com.taxplus.taxplusbackend.secret.SecretMsg;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


@Component
public class TcCOSUtils {
    private String endpoint = "https://cos.ap-shanghai.myqcloud.com";

    private COSClient createCosClient() {
        COSCredentials cred = new BasicCOSCredentials(SecretMsg.SecretId, SecretMsg.SecretKey);
        // clientConfig 中包含了设置 region, https(默认 http), 超时, 代理等 set 方法, 使用可参见源码或者常见问题 Java SDK 部分。
        Region region = new Region("ap-shanghai");
        ClientConfig clientConfig = new ClientConfig(region);
        // 这里建议设置使用 https 协议
        // 从 5.6.54 版本开始，默认使用了 https
        clientConfig.setHttpProtocol(HttpProtocol.https);
        // 3 生成 cos 客户端。
        COSClient cosClient = new COSClient(cred, clientConfig);
        return cosClient;
    }

    public String upload(MultipartFile file) throws IOException {
        COSClient cosClient = createCosClient();

        InputStream inputStream = file.getInputStream();
//        拿到初始文件名
        String originalFilename = file.getOriginalFilename();
        String fileName = UUID.randomUUID() + originalFilename.substring(originalFilename.lastIndexOf("."));

        // 指定要上传的文件(初始文件名)
        File localFile = new File("D:\\000web\\tax-plus\\src\\assets\\imgs\\" + originalFilename);
        // 指定文件将要存放的存储桶
        String bucketName = "tax-plus-coursecover-1317662942";
        // 指定文件上传到 COS 上的路径，即对象键。例如对象键为 folder/picture.jpg，则表示将文件 picture.jpg 上传到 folder 路径下
        String key = fileName;

        PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
        PutObjectResult putObjectResult = cosClient.putObject(putObjectRequest);

        String url = endpoint.split("//")[0] + "//" + bucketName + "." + endpoint.split("//")[1] + "/" + fileName;
        cosClient.shutdown();
        return url;
    }

//    public String download(String fileName) {
//        System.out.println("download");
//        TransferManager transferManager = createTransferManager();
//        COSClient cosClient = createCosClient();
//        // 指定文件将要存放的存储桶
//        String bucketName = "tax-plus-coursecover-1317662942";
//        // 指定文件上传到 COS 上的路径，即对象键。例如对象键为 folder/picture.jpg，则表示将文件 picture.jpg 上传到 folder 路径下
//        String key = "file/" + fileName;
//        //下载到工程目录下的imgs文件夹中
//        File downloadFile = new File(System.getProperty("user.dir") + "/imgs/" + fileName);
//
//        GetObjectRequest getObjectRequest = new GetObjectRequest(bucketName, key);
//        try {
//            //返回一个异步结果 Donload, 可同步的调用 waitForCompletion 等待下载结束, 成功返回 void, 失败抛出异常
//            Download download = transferManager.download(getObjectRequest, downloadFile);
//            download.waitForCompletion();
//            cosClient.shutdown();
//            return "下载文件成功";
//        } catch (InterruptedException e) {
//            cosClient.shutdown();
//            return "下载文件失败";
//        }
//    }

    private TransferManager createTransferManager() {
        //初始化客户端
        COSClient cosClient = createCosClient();
        //创建线程池
        ExecutorService threadPool = Executors.newFixedThreadPool(32);
        //创建 TransferManager
        return new TransferManager(cosClient, threadPool);
    }
}
