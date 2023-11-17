package com.taxplus.taxplusbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.taxplus.taxplusbackend.domain.Course;
import com.taxplus.taxplusbackend.domain.Student;
import com.taxplus.taxplusbackend.mapper.StudentMapper;
import com.taxplus.taxplusbackend.service.StudentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements StudentService {
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Map<String, Student>> getStudentMsgById(int student_id) {
        List<Map<String, Student>> resultArray = studentMapper.getStudentMsgById(student_id);
        if (resultArray == null) {
            return null;
        }
        log.info(String.valueOf(resultArray));

        return resultArray;
    }

    @Override
    public void setCourseIntendencies(Student student) {
        studentMapper.setCourseIntendencies(student);
    }

    //登录
    @Override
    public Student selectStudent(Student student) {
        if (student.getPhone_number() == null || student.getUser_password() == null) {
            return null;
        }
        return studentMapper.selectOneStudent(student);
    }

    //    请求数据库中的资料
    @Override
    public Student getInfo(String phone_number) {
        Student result = studentMapper.findByPhone(phone_number);
        if (result == null) {
//            "请求的数据不存在"
            return null;
        }

        // 创建新的User对象
        //因为密码不能发出去，所以新建一个对象
        Student s = new Student();
        s.setPhone_number(phone_number);
        s.setStudent_id(result.getStudent_id());
        // 通过查询结果向新User对象中封装属性：username,phone
        s.setStudent_name(result.getStudent_name());
        s.setGender(result.getGender());
        s.setAvatar(result.getAvatar());
        s.setEmail(result.getEmail());
        // 返回新User对象
        return s;
    }

}
