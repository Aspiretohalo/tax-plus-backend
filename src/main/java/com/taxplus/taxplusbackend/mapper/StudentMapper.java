package com.taxplus.taxplusbackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.taxplus.taxplusbackend.domain.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
@Mapper
public interface StudentMapper extends BaseMapper<Student> {
    @Select(value = "select * from students where phone_number=#{phone_number} and user_password = #{user_password}")
//使用注解方式，也可用xml方式（编写.xml文件放在resources下且要在application.yml中配置localtion等）
    Student selectOneStudent(Student student);

    @Select(value = "SELECT * FROM students WHERE phone_number=#{phone_number}")
    Student findByPhone(String phone_number);

    @Select(value = "UPDATE students SET avatar=#{avatar} WHERE phone_number=#{phone_number}")
    void updateAvatar(Student student);


}