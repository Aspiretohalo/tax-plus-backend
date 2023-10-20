package com.taxplus.taxplusbackend.controller;

import com.taxplus.taxplusbackend.common.R;
import com.taxplus.taxplusbackend.service.VodService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

//@Api(tags="腾讯云点播")
@RestController
@RequestMapping("/vod")
@CrossOrigin
public class VodController {
    @Autowired
    private VodService vodService;

    //上传视频接口
    @PostMapping("upload")
    public R upload() {

        String fileId = vodService.uploadVideo();
        return R.success(fileId);
    }

    //    删除视频接口
    @DeleteMapping("remove/{fileId}")
    public R remove(@PathVariable String fileId) {
        vodService.removeVideo(fileId);
        return R.success(null);
    }
}
