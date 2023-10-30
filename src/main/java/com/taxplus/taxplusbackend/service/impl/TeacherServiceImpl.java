package com.taxplus.taxplusbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.taxplus.taxplusbackend.domain.Teacher;
import com.taxplus.taxplusbackend.mapper.TeacherMapper;
import com.taxplus.taxplusbackend.service.TeacherService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher> implements TeacherService {
    @Autowired
    private TeacherMapper teacherMapper;

    //    登录
    @Override
    public Teacher selectTeacher(Teacher teacher) {
        if (teacher.getPhone_number() == null || teacher.getUser_password() == null) {
            return null;
        }
        return teacherMapper.selectOneTeacher(teacher);
    }

    //    请求数据库中的资料
    @Override
    public Teacher getInfo(String phone_number) {
        Teacher result = teacherMapper.findByPhone(phone_number);
        if (result == null) {
//            "请求的数据不存在"
            return null;
        }

        // 创建新的User对象
        //因为密码不能发出去，所以新建一个对象
        Teacher t = new Teacher();
        t.setPhone_number(phone_number);
        t.setTeacher_id(result.getTeacher_id());
        // 通过查询结果向新User对象中封装属性：username,phone
        t.setTeacher_name(result.getTeacher_name());
        t.setGender(result.getGender());
        t.setAvatar(result.getAvatar());
        t.setEmail(result.getEmail());
        // 返回新User对象
        return t;
    }

}
