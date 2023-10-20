package com.taxplus.taxplusbackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.taxplus.taxplusbackend.domain.*;

import java.util.List;
import java.util.Map;

public interface CourseService extends IService<Course>{

    List<Map<String, Course>> getCourses(int student_id);
//    String getTeacher_name(int teacher_id);
    List<Map<String, Course>> getAllCourses();
    List<Map<String, Comment>> getComment(int course_id);
    List<Map<String, Evaluation>> getEvaluation(int course_id);

    List<Map<String, Notice>> getNotice(int course_id);
    List<Map<String, Video>> getVideo(int course_id);



}
