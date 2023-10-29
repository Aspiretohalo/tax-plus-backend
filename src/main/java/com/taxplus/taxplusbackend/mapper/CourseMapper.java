package com.taxplus.taxplusbackend.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.taxplus.taxplusbackend.domain.*;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface CourseMapper extends BaseMapper<Course> {

    @Select(value = "SELECT Courses.*, Teachers.teacher_name FROM CourseProgress JOIN Courses ON CourseProgress.course_id = Courses.course_id JOIN Teachers ON Courses.course_teacher = Teachers.teacher_id WHERE CourseProgress.student_id = #{student_id};")
    List<Map<String, Course>> getCourses(int student_id);

    @Select(value = "SELECT *,Teachers.teacher_name FROM courses JOIN Teachers ON Courses.course_teacher = Teachers.teacher_id WHERE course_teacher = #{teacher_id};")
    List<Map<String, Course>> getTeacherCourses(int teacher_id);

    @Select(value = "insert into courses (course_name,course_description,course_label,course_teacher,course_url,status,tag_type,choose_amount,course_begin_time) values(#{course_name},#{course_description},#{course_label},#{course_teacher},#{course_url},#{status},#{tag_type},#{choose_amount},#{course_begin_time})")
    void setCourse(Course course);

    @Select(value = "SELECT courses.*, teachers.teacher_name FROM courses JOIN teachers ON courses.course_teacher = teachers.teacher_id;")
    List<Map<String, Course>> getAllCourses();

    @Select(value = "SELECT * FROM Comments WHERE course_id = #{course_id};")
    List<Map<String, Comment>> getComment(int course_id);

    @Select(value = "SELECT * FROM Evaluations WHERE course_id = #{course_id};")
    List<Map<String, Evaluation>> getEvaluation(int course_id);

    @Select(value = "SELECT * FROM Notices WHERE course_id = #{course_id};")
    List<Map<String, Notice>> getNotice(int course_id);

    @Select(value = "SELECT * FROM file_data WHERE course_id = #{course_id};")
    List<Map<String, FileData>> getFileData(int course_id);

    @Select(value = "SELECT * FROM Chapter WHERE course_id = #{course_id};")
    List<Map<String, Chapter>> getChapter(int course_id);

    @Select(value = "insert into comments (course_id,commentator,comment_text,comment_time,reply_to) values(#{course_id},#{commentator},#{comment_text},#{comment_time},#{reply_to})")
    void setComment(Comment comment);

    @Select(value = "insert into evaluations (course_id,evaluator,evaluation_stars,evaluation_text,evaluation_time) values(#{course_id},#{evaluator},#{evaluation_stars},#{evaluation_text},#{evaluation_time})")
    void setEvaluation(Evaluation evaluation);

    @Select(value = "insert into notices (course_id,announcer,notice_title,notice_text,notice_time) values(#{course_id},#{announcer},#{notice_title},#{notice_text},#{notice_time})")
    void setNotice(Notice notice);

    @Select(value = "insert into file_data (course_id,file_name,file_type,file_size,file_url) values(#{course_id},#{file_name},#{file_type},#{file_size},#{file_url})")
    void setFileData(FileData fileData);

}
