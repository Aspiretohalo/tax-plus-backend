package com.taxplus.taxplusbackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.taxplus.taxplusbackend.domain.Course;
import com.taxplus.taxplusbackend.domain.Student;
import com.taxplus.taxplusbackend.domain.Video;

public interface VideoService extends IService<Video> {
    void setVideo(Video video);
}
