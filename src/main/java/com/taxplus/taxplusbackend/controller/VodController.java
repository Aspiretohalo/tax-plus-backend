package com.taxplus.taxplusbackend.controller;

import com.taxplus.taxplusbackend.common.R;
import com.taxplus.taxplusbackend.service.VodService;
import com.taxplus.taxplusbackend.utils.PsignUtils;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

//@Api(tags="腾讯云点播")
//@Slf4j
@RestController
@RequestMapping("/vod")
@CrossOrigin
public class VodController {
    @Autowired
    private VodService vodService;

    //上传视频接口
    @PostMapping("upload")
    public R upload(@RequestParam("file") MultipartFile file) throws IOException {
//        把传过来的文件通过io写入内存
        InputStream inputStream = file.getInputStream();
//        拿到初始文件名
        String originalFilename = file.getOriginalFilename();

        String fileId = vodService.uploadVideo(inputStream, originalFilename);
        String psign = PsignUtils.Psign(fileId);
        ArrayList<String> res = new ArrayList<>();
        res.add(fileId);
        res.add(psign);
        System.out.println(res);
        return R.success(res);
    }

    //    删除视频接口
    @DeleteMapping("remove/{fileId}")
    public R remove(@PathVariable String fileId) {
        vodService.removeVideo(fileId);
        return R.success(null);
    }
}
