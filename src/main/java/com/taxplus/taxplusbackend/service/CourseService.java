package com.taxplus.taxplusbackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.taxplus.taxplusbackend.domain.Course;

import java.util.List;
import java.util.Map;

public interface CourseService extends IService<Course>{

    List<Map<String, Course>> getCourses(int student_id);

}
