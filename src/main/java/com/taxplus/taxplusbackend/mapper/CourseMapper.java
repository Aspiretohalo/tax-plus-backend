package com.taxplus.taxplusbackend.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.taxplus.taxplusbackend.domain.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface CourseMapper extends BaseMapper<Course> {


    @Select(value = "SELECT Courses.* FROM CourseProgress JOIN Courses ON CourseProgress.course_id = Courses.course_id WHERE CourseProgress.student_id = #{student_id};")
    List<Map<String, Course>> getCourses(int student_id);

}
