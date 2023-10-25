package com.taxplus.taxplusbackend.controller;

import com.taxplus.taxplusbackend.common.R;
import com.taxplus.taxplusbackend.service.CourseService;
import com.taxplus.taxplusbackend.utils.TcCOSUtils;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.UUID;

@RestController
@Slf4j
public class FileController {
    @Autowired
    private TcCOSUtils tcCOSUtils;

    //    课程资料上传
    @PostMapping("/course/data/upload")
    public R<String> uploadData(MultipartFile file) throws IOException {

        log.info("文件上传:{}", file.getOriginalFilename());
        String url = tcCOSUtils.upload(file);
        log.info("文件上传完成，文件访问的url:{}", url);

        return R.success(url);
    }

//    @GetMapping("/course/data/download")
//    public R<Object> download(@RequestParam("fileName") String fileName, ServletRequest request, ServletResponse response) {
//        HttpServletRequest req = (HttpServletRequest) request;
//
//        log.info("文件下载：" + fileName);
//        String res = tcCOSUtils.download(fileName);
//        log.info(res);
//        return R.success(res);
//    }

    //    用户头像
    @PostMapping("/avatar/upload")
    public R<String> uploadAvatar(MultipartFile file) throws IOException {

        log.info("文件上传:{}", file.getOriginalFilename());
        String url = tcCOSUtils.upload(file);
        log.info("文件上传完成，文件访问的url:{}", url);

        return R.success(url);
    }

    //    章节封面上传
    @PostMapping("/course/cover/upload")
    public R<String> upload(MultipartFile file) throws IOException {

        log.info("文件上传:{}", file.getOriginalFilename());
        String url = tcCOSUtils.upload(file);
        log.info("文件上传完成，文件访问的url:{}", url);

        return R.success(url);
    }
}
