package com.taxplus.taxplusbackend.mapper;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.taxplus.taxplusbackend.domain.*;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

@Mapper
public interface CourseMapper extends BaseMapper<Course> {

    @Select(value = "SELECT cp.*, c.course_teacher,c.course_name,t.teacher_name FROM courseprogress cp JOIN courses c ON cp.course_id = c.course_id JOIN teachers t ON c.course_teacher=t.teacher_id WHERE cp.student_id = #{student_id};")
    List<Map<String, Course>> getCourseByStudentId(int student_id);

    @Select(value = "SELECT courseprogress.*, students.student_name from courseprogress JOIN students ON courseprogress.student_id = students.student_id where course_id=#{course_id};")
    List<Map<String, Course>> getAllCourseLearningProgress(int course_id);

    @Select(value = "SELECT COUNT(*) AS subDiscussion_count FROM sub_discussion WHERE commentator = #{commentator};")
    List<Map<String, Course>> getSubDiscussionNumber(int commentator);

    @Select(value = "SELECT COUNT(*) AS discussion_count FROM discussion WHERE commentator = #{commentator};")
    List<Map<String, Course>> getDiscussionNumber(int commentator);

    @Select(value = "SELECT COUNT(*) AS evaluation_count FROM evaluations WHERE evaluator = #{evaluator} AND course_id = #{course_id};")
    List<Map<String, Course>> getEvaluationNumber(int course_id, int evaluator);

    @Select(value = "SELECT * FROM courseprogress WHERE course_id = #{course_id} AND student_id = #{student_id};")
    List<Map<String, Course>> getCourseLearningProgress(int course_id, int student_id);

    @Select(value = "UPDATE courseprogress SET confirmation_time = (confirmation_time + #{confirmation_time})/2 WHERE course_id = #{course_id} AND student_id = #{student_id};")
    void setConfirmationTime(CourseProgress courseProgress);

    @Select(value = "UPDATE courseprogress SET course_learning_progress = course_learning_progress + #{course_learning_progress} WHERE course_id = #{course_id} AND student_id = #{student_id};")
    void setCourseLearningProgress(CourseProgress courseProgress);

    @Select(value = "insert into courseprogress (course_id,student_id) values (#{course_id},#{student_id})")
    void selectTheCourse(CourseProgress courseProgress);

    @Select(value = "insert into living_courses (course_id,living_course_name,course_teacher,start_time) values (#{course_id},#{living_course_name},#{course_teacher},#{start_time})")
    void createNewLiving(LivingCourse livingCourse);

    @Select(value = "update living_courses set meeting_id=#{meeting_id},course_id=#{course_id},living_course_name=#{living_course_name},living_course_description=#{living_course_description},course_teacher=#{course_teacher} where living_course_id=#{living_course_id}")
    void addMeetingId(LivingCourse livingCourse);

    @Select(value = "SELECT * FROM courseprogress WHERE course_id = #{course_id} AND student_id = #{student_id};")
    List<Map<String, Course>> hasSelected(int course_id, int student_id);

    @Select(value = "SELECT Courses.*, Teachers.teacher_name FROM CourseProgress JOIN Courses ON CourseProgress.course_id = Courses.course_id JOIN Teachers ON Courses.course_teacher = Teachers.teacher_id WHERE CourseProgress.student_id = #{student_id};")
    List<Map<String, Course>> getCourses(int student_id);

    @Select(value = "SELECT Courses.* , Teachers.teacher_name FROM courses JOIN Teachers ON Courses.course_teacher = Teachers.teacher_id WHERE course_id = #{course_id};")
    List<Map<String, Course>> getCourseByCourseId(int course_id);

    @Select(value = "SELECT *,Teachers.teacher_name FROM courses JOIN Teachers ON Courses.course_teacher = Teachers.teacher_id WHERE course_teacher = #{teacher_id};")
    List<Map<String, Course>> getTeacherCourses(int teacher_id);

    @Select(value = "insert into courses (course_name,course_description,course_label,course_teacher,course_url) values(#{course_name},#{course_description},#{course_label},#{course_teacher},#{course_url})")
    void setCourse(Course course);

    @Select(value = "SELECT courses.*, teachers.teacher_name FROM courses JOIN teachers ON courses.course_teacher = teachers.teacher_id;")
    List<Map<String, Course>> getAllCourses();

    @Select(value = "SELECT living_courses.*,courses.course_name AS course_name, teachers.teacher_name,teachers.avatar FROM living_courses JOIN teachers ON living_courses.course_teacher = teachers.teacher_id JOIN courses ON living_courses.course_id = courses.course_id;")
    List<Map<String, Course>> getAllLivingCourses();

    @Select(value = "SELECT living_courses.*, teachers.teacher_name FROM living_courses JOIN teachers ON living_courses.course_teacher = teachers.teacher_id WHERE living_courses.course_id =#{course_id};")
    List<Map<String, Course>> getLivingNotice(int course_id);

    @Select(value = "SELECT evaluations.*, (SELECT ROUND(AVG(evaluation_stars), 1) FROM evaluations WHERE course_id = #{course_id}) as average_stars,  students.student_name,   students.avatar FROM evaluations JOIN students ON evaluations.evaluator = students.student_id WHERE evaluations.course_id = #{course_id};")
    List<Map<String, Evaluation>> getEvaluation(int course_id);

    @Select(value = "SELECT notices.*,teachers.teacher_name FROM Notices JOIN teachers ON Notices.announcer = teachers.teacher_id WHERE Notices.course_id = #{course_id};")
    List<Map<String, Notice>> getNotice(int course_id);

    @Select(value = "SELECT * FROM Chapter WHERE course_id = #{course_id};")
    List<Map<String, Chapter>> getChapter(int course_id);

    @Select(value = "insert into evaluations (course_id,evaluator,evaluation_stars,evaluation_text,evaluation_time) values(#{course_id},#{evaluator},#{evaluation_stars},#{evaluation_text},#{evaluation_time})")
    void setEvaluation(Evaluation evaluation);

    @Select(value = "insert into notices (course_id,announcer,notice_title,notice_text,notice_time) values(#{course_id},#{announcer},#{notice_title},#{notice_text},#{notice_time})")
    void setNotice(Notice notice);

}
