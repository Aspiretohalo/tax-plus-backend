package com.taxplus.taxplusbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.taxplus.taxplusbackend.domain.Course;
import com.taxplus.taxplusbackend.domain.Teacher;
import com.taxplus.taxplusbackend.domain.Video;
import com.taxplus.taxplusbackend.mapper.CourseMapper;
import com.taxplus.taxplusbackend.mapper.TeacherMapper;
import com.taxplus.taxplusbackend.mapper.VideoMapper;
import com.taxplus.taxplusbackend.service.TeacherService;
import com.taxplus.taxplusbackend.service.VideoService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class VideoServiceImpl extends ServiceImpl<VideoMapper, Video> implements VideoService {
    @Autowired(required = false)
    private VideoMapper videoMapper;

    @Override
    public void setVideo(Video video) {
        videoMapper.setVideo(video);
    }


}
