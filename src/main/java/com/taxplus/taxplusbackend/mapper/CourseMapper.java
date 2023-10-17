package com.taxplus.taxplusbackend.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.taxplus.taxplusbackend.domain.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
public interface CourseMapper extends BaseMapper<Course>{


    @Select (value = "Select * from courses where course_id = #{course_id}")
    Course selectonecourse(Course course);



}
