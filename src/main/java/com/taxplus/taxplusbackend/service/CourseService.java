package com.taxplus.taxplusbackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.taxplus.taxplusbackend.domain.*;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

public interface CourseService extends IService<Course> {

    //    新增直播房间号
    void addMeetingId(LivingCourse livingCourse);

    List<Map<String, Course>> hasSelected(int course_id, int student_id);

    List<Map<String, Course>> getLivingNotice(int course_id);
    List<Map<String, Course>> getAllLivingCourses();

    List<Map<String, Course>> getCourses(int student_id);

    List<Map<String, Course>> getCourseByCourseId(int course_id);

    //    String getTeacher_name(int teacher_id);
    List<Map<String, Course>> getAllCourses();

    List<Map<String, Comment>> getComment(int course_id);

    List<Map<String, Evaluation>> getEvaluation(int course_id);

    List<Map<String, Notice>> getNotice(int course_id);

    List<Map<String, Chapter>> getChapter(int course_id);

    void setCourse(Course course);

    void setComment(Comment comment);

    void setEvaluation(Evaluation evaluation);

    void setNotice(Notice notice);

    List<Map<String, Course>> getTeacherCourses(int teacher_id);

    List<Map<String, FileData>> getFileData(int parseInt);

    void setFileData(FileData fileData);
}
