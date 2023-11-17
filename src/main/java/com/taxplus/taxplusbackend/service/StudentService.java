package com.taxplus.taxplusbackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.taxplus.taxplusbackend.domain.CourseProgress;
import com.taxplus.taxplusbackend.domain.Student;

import java.util.List;
import java.util.Map;

public interface StudentService extends IService<Student> {

    void setCourseIntendencies(Student student);

    Student selectStudent(Student student);

    Student getInfo(String phone_number);


    List<Map<String, Student>> getStudentMsgById(int student_id);
}