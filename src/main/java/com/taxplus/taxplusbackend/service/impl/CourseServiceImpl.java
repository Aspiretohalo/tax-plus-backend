package com.taxplus.taxplusbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.taxplus.taxplusbackend.domain.Course;
import com.taxplus.taxplusbackend.mapper.CourseMapper;
import com.taxplus.taxplusbackend.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {
    @Autowired
    private CourseMapper courseMapper;

    @Override
    public Course selectCourse(Course course) {
        if ( course.getCourse_url() == null) {
            return null;
        }
        return courseMapper.selectonecourse(course);
    }

    //    请求数据库中的资料
//    @Override
//    public Student getInfo(String phone_number) {
//        Student result = studentMapper.findByPhone(phone_number);
//        if (result == null) {
////            "请求的数据不存在"
//            return null;
//        }

        // 创建新的User对象
        //因为密码不能发出去，所以新建一个对象
//        Course c = new Course();
//        c.setPhone_number(phone_number);
//        c.setCourse_id(result.getCourse_id());
        // 通过查询结果向新User对象中封装属性：username,phone
//        c.setStudent_name(result.getStudent_name());
//        c.setGender(result.getGender());
//        c.setAvatar(result.getAvatar());
        // 返回新User对象
//        return c;
//    }

//    @Override
//    public void updateAvatar(Student student) {
//        studentMapper.updateAvatar(student);
//    }
}
