package com.taxplus.taxplusbackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.taxplus.taxplusbackend.domain.Course;

public interface CourseService extends IService<Course>{

    Course selectCourse(Course course);

}
