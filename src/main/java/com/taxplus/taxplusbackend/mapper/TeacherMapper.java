package com.taxplus.taxplusbackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import com.taxplus.taxplusbackend.domain.Teacher;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface TeacherMapper extends BaseMapper<Teacher> {
    @Select(value = "UPDATE teachers SET avatar=#{avatar} WHERE teacher_id = #{teacher_id};")
    void setTeacherAvatar(Teacher teacher);
    @Select(value = "UPDATE teachers SET teacher_name=#{teacher_name},email=#{email},gender=#{gender} WHERE teacher_id = #{teacher_id};")
    void setTeacherMsg(Teacher teacher);
    @Select(value = "SELECT * FROM teachers  WHERE teacher_id = #{teacher_id};")
    List<Map<String, Teacher>> getTeacherMsgById(int teacher_id);

    @Select(value = "select * from teachers where phone_number=#{phone_number} and user_password = #{user_password}")
//使用注解方式，也可用xml方式（编写.xml文件放在resources下且要在application.yml中配置localtion等）
    Teacher selectOneTeacher(Teacher teacher);

    @Select(value = "SELECT * FROM teachers WHERE phone_number=#{phone_number}")
    Teacher findByPhone(String phone_number);


}