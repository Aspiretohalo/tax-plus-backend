package com.taxplus.taxplusbackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.taxplus.taxplusbackend.domain.Teacher;

public interface TeacherService extends IService<Teacher> {

    Teacher selectTeacher(Teacher teacher);

    Teacher getInfo(String phone_number);




}