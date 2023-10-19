package com.taxplus.taxplusbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.taxplus.taxplusbackend.domain.Course;
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


}
