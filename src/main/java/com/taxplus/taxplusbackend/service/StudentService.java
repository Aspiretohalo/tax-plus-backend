package com.taxplus.taxplusbackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.taxplus.taxplusbackend.domain.Student;

public interface StudentService extends IService<Student> {

    Student selectStudent(Student student);


    Student getInfo(String phone_number);




}