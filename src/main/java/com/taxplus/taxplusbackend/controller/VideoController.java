package com.taxplus.taxplusbackend.controller;

import com.taxplus.taxplusbackend.common.R;
import com.taxplus.taxplusbackend.domain.Teacher;
import com.taxplus.taxplusbackend.domain.Video;
import com.taxplus.taxplusbackend.service.CourseService;
import com.taxplus.taxplusbackend.service.VideoService;
import com.taxplus.taxplusbackend.utils.JwtUtils;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping
public class VideoController {
    @Autowired
    private VideoService videoService;

    @PostMapping("/teacher/setVideo")
    public R<Object> setVideo(@RequestBody Video video) {
        videoService.setVideo(video);
        log.info("存入新事项：{}", video.getVideo_title());

        return R.success(null);
    }
}
