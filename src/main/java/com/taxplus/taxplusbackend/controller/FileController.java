package com.taxplus.taxplusbackend.controller;

import com.taxplus.taxplusbackend.common.R;
import com.taxplus.taxplusbackend.service.CourseService;
import com.taxplus.taxplusbackend.utils.TcCOSUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
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
//    private CourseService courseService;

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
