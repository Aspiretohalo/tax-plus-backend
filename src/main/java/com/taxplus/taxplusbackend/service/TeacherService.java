package com.taxplus.taxplusbackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.taxplus.taxplusbackend.domain.Teacher;

import java.util.List;
import java.util.Map;

public interface TeacherService extends IService<Teacher> {

    Teacher selectTeacher(Teacher teacher);

    Teacher getInfo(String phone_number);


    List<Map<String, Teacher>> getTeacherMsgById(int teacher_id);
}