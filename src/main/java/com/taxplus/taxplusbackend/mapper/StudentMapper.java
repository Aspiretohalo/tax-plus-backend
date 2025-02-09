package com.taxplus.taxplusbackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.taxplus.taxplusbackend.domain.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface StudentMapper extends BaseMapper<Student> {
    @Select(value = "UPDATE students SET avatar=#{avatar} WHERE student_id = #{student_id};")
    void setStudentAvatar(Student student);
    @Select(value = "UPDATE students SET student_name=#{student_name},email=#{email},gender=#{gender} WHERE student_id = #{student_id};")
    void setStudentMsg(Student student);
    @Select(value = "SELECT * FROM students  WHERE student_id = #{student_id};")
    List<Map<String, Student>> getStudentMsgById(int student_id);

    @Select(value = "SELECT course_intendencies FROM students WHERE student_id=#{student_id}")
    String getCourseIntendencies(int student_id);

    @Select(value = "UPDATE students SET available_time=#{available_time},course_intendencies=#{course_intendencies} where  student_id = #{student_id}")
    void setCourseIntendencies(Student student);

    @Select(value = "select * from students where phone_number=#{phone_number} and user_password = #{user_password}")
//使用注解方式，也可用xml方式（编写.xml文件放在resources下且要在application.yml中配置localtion等）
    Student selectOneStudent(Student student);

    @Select(value = "SELECT * FROM students WHERE phone_number=#{phone_number}")
    Student findByPhone(String phone_number);
}