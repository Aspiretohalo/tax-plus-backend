package com.taxplus.taxplusbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.taxplus.taxplusbackend.domain.*;
import com.taxplus.taxplusbackend.mapper.CourseMapper;
import com.taxplus.taxplusbackend.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {
    @Autowired(required = false)
    private CourseMapper courseMapper;

    @Override
    public List<Map<String, Course>> getCourses(int student_id) {
        List<Map<String, Course>> resultArray = courseMapper.getCourses(student_id);

        if (resultArray == null) {
//            "请求的数据不存在"
            return null;
        }
        log.info(String.valueOf(resultArray));

        return resultArray;
    }

    @Override
    public void setCourse(Course course) {
        course.setStatus("即将开始");
        course.setTag_type("info");
        course.setChoose_amount(0);
        courseMapper.setCourse(course);
    }

//    public void setCover(String course_url) {
//        courseMapper.setCover(course_url);
//    }

    @Override
    public List<Map<String, Course>> getAllCourses() {
        List<Map<String, Course>> resultArray = courseMapper.getAllCourses();
        if (resultArray == null) {
            return null;
        }
        log.info(String.valueOf(resultArray));

        return resultArray;
    }

    @Override
    public List<Map<String, Comment>> getComment(int course_id) {
        List<Map<String, Comment>> resultArray = courseMapper.getComment(course_id);

        if (resultArray == null) {
//            "请求的数据不存在"
            return null;
        }
        log.info(String.valueOf(resultArray));

        return resultArray;
    }

    @Override
    public List<Map<String, Evaluation>> getEvaluation(int course_id) {
        List<Map<String, Evaluation>> resultArray = courseMapper.getEvaluation(course_id);

        if (resultArray == null) {
//            "请求的数据不存在"
            return null;
        }
        log.info(String.valueOf(resultArray));

        return resultArray;
    }

    @Override
    public List<Map<String, Notice>> getNotice(int course_id) {
        List<Map<String, Notice>> resultArray = courseMapper.getNotice(course_id);

        if (resultArray == null) {
//            "请求的数据不存在"
            return null;
        }
        log.info(String.valueOf(resultArray));

        return resultArray;
    }

    @Override
    public List<Map<String, Chapter>> getChapter(int course_id) {
        List<Map<String, Chapter>> resultArray = courseMapper.getChapter(course_id);

        if (resultArray == null) {
//            "请求的数据不存在"
            return null;
        }
        log.info(String.valueOf(resultArray));

        return resultArray;
    }


}
