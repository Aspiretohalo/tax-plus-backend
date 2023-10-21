package com.taxplus.taxplusbackend.service;

import java.io.InputStream;

public interface VodService {
    void removeVideo(String fileId);
    //上传视频
    String uploadVideo(InputStream inputStream,String originalFilename);
}
