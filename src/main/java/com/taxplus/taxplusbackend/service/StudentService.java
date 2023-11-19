package com.taxplus.taxplusbackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.taxplus.taxplusbackend.common.R;
import com.taxplus.taxplusbackend.domain.CourseProgress;
import com.taxplus.taxplusbackend.domain.Student;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Map;

public interface StudentService extends IService<Student> {
    void setStudentAvatar(Student student);
    void setStudentMsg(Student student);
    void setCourseIntendencies(Student student);

    Student selectStudent(Student student);

    Student getInfo(String phone_number);

    List<Map<String, Student>> getStudentMsgById(int student_id);
}