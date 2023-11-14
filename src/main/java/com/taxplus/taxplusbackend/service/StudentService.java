package com.taxplus.taxplusbackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.taxplus.taxplusbackend.domain.CourseProgress;
import com.taxplus.taxplusbackend.domain.Student;

public interface StudentService extends IService<Student> {

    void setCourseIntendencies(Student student);

    Student selectStudent(Student student);

    Student getInfo(String phone_number);


}