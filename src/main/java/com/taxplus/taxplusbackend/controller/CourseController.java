package com.taxplus.taxplusbackend.controller;

import com.taxplus.taxplusbackend.common.R;
import com.taxplus.taxplusbackend.domain.*;
import com.taxplus.taxplusbackend.service.CourseService;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/getRecommendedCourse")
    public List<Map<String, Course>> getRecommendedCourse(@RequestParam("student_id") String student_id, ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;
        log.info(student_id);
        List<Map<String, Course>> list;
        list = courseService.getRecommendedCourse(Integer.parseInt(student_id));

        return list;
    }

    @GetMapping("/getCourseByStudentId")
    public List<Map<String, Course>> getCourseByStudentId(@RequestParam("student_id") String student_id, ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;

        List<Map<String, Course>> list;
        list = courseService.getCourseByStudentId(Integer.parseInt(student_id));

        return list;
    }

    @GetMapping("/getAllCourseLearningProgress")
    public List<Map<String, Course>> getAllCourseLearningProgress(@RequestParam("course_id") String course_id, ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;

        List<Map<String, Course>> list;
        list = courseService.getAllCourseLearningProgress(Integer.parseInt(course_id));

        return list;
    }

    @GetMapping("/getSubDiscussionNumber")
    public List<Map<String, Course>> getSubDiscussionNumber(@RequestParam("commentator") String commentator, ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;

        List<Map<String, Course>> list;
        list = courseService.getSubDiscussionNumber(Integer.parseInt(commentator));

        return list;
    }

    @GetMapping("/getDiscussionNumber")
    public List<Map<String, Course>> getDiscussionNumber(@RequestParam("commentator") String commentator, ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;

        List<Map<String, Course>> list;
        list = courseService.getDiscussionNumber(Integer.parseInt(commentator));

        return list;
    }

    @GetMapping("/getEvaluationNumber")
    public List<Map<String, Course>> getEvaluationNumber(@RequestParam("course_id") String course_id, @RequestParam("evaluator") String evaluator, ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;

        List<Map<String, Course>> list;
        list = courseService.getEvaluationNumber(Integer.parseInt(course_id), Integer.parseInt(evaluator));

        return list;
    }

    @GetMapping("/getCourseLearningProgress")
    public List<Map<String, Course>> getCourseLearningProgress(@RequestParam("course_id") String course_id, @RequestParam("student_id") String student_id, ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;

        List<Map<String, Course>> list;
        list = courseService.getCourseLearningProgress(Integer.parseInt(course_id), Integer.parseInt(student_id));

        return list;
    }

    @PostMapping("/setConfirmationTime")
    public R<Object> setConfirmationTime(@RequestBody CourseProgress courseProgress) {
        courseService.setConfirmationTime(courseProgress);
        log.info("存入：{}", courseProgress.getConfirmation_time());

        return R.success(null);
    }

    @PostMapping("/setCourseLearningProgress")
    public R<Object> setCourseLearningProgress(@RequestBody CourseProgress courseProgress) {
        courseService.setCourseLearningProgress(courseProgress);
        log.info("存入：{}", courseProgress.getCourse_learning_progress());

        return R.success(null);
    }

    @PostMapping("/selectTheCourse")
    public R<Object> selectTheCourse(@RequestBody CourseProgress courseProgress) {
        courseService.selectTheCourse(courseProgress);
        log.info("存入：{}", courseProgress.getCourse_id());

        return R.success(null);
    }

    @GetMapping("/judgeSelected")
    public List<Map<String, Course>> JudgeSelected(@RequestParam("course_id") String course_id, @RequestParam("student_id") String student_id, ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;

        List<Map<String, Course>> list;
        list = courseService.hasSelected(Integer.parseInt(course_id), Integer.parseInt(student_id));

        return list;
    }

    @PostMapping("/createNewLiving")
    public R<Object> createNewLiving(@RequestBody LivingCourse livingCourse) {
        courseService.createNewLiving(livingCourse);
        log.info("存入：{}", livingCourse.getLiving_course_name());

        return R.success(null);
    }

    @PutMapping("/addMeetingId")
    public R<Object> addMeetingId(@RequestBody LivingCourse livingCourse) {
        courseService.addMeetingId(livingCourse);
        log.info("存入新事项：{}", livingCourse.getMeeting_id());
        return R.success(null);
    }

    //获取所有直播课程
    @GetMapping("/getLivingNotice")
    public List<Map<String, Course>> getLivingNotice(@RequestParam("course_id") String course_id, ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;

        List<Map<String, Course>> list;
        list = courseService.getLivingNotice(Integer.parseInt(course_id));

        return list;
    }

    //    getAllLivingCourses
    @GetMapping("/getAllLivingCourses")
    public List<Map<String, Course>> getAllLivingCourses(ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;

        List<Map<String, Course>> list;
        list = courseService.getAllLivingCourses();

        return list;
    }

    //获取某个用户的课程
    @GetMapping("/getCourses")
    public List<Map<String, Course>> getCourses(@RequestParam("student_id") String student_id, ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;

        List<Map<String, Course>> list;
        list = courseService.getCourses(Integer.parseInt(student_id));
        return list;
    }

    @GetMapping("/getCourseByCourseId")
    public List<Map<String, Course>> getCourseByCourseId(@RequestParam("course_id") String course_id, ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;

        List<Map<String, Course>> list;
        list = courseService.getCourseByCourseId(Integer.parseInt(course_id));
        return list;
    }

    //获取某个用户的课程
    @GetMapping("/getTeacherCourses")
    public List<Map<String, Course>> getTeacherCourses(@RequestParam("teacher_id") String teacher_id, ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;

        List<Map<String, Course>> list;
        list = courseService.getTeacherCourses(Integer.parseInt(teacher_id));
        return list;
    }

    @PostMapping("/teacher/setCourse")
    public R<Object> setCourse(@RequestBody Course course) {
        courseService.setCourse(course);
        log.info("存入新课程：{}", course.getCourse_name());

        return R.success(null);
    }

    //获取所有课程
    @GetMapping("/getAllCourses")
    public List<Map<String, Course>> getAllCourses(ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;

        List<Map<String, Course>> list;
        list = courseService.getAllCourses();

        return list;
    }

//    //    获取某一门课程的评论comment
//    @GetMapping("/course/getComment")
//    public List<Map<String, Comment>> getComment(@RequestParam("course_id") String course_id, ServletRequest request, ServletResponse response) {
//        HttpServletRequest req = (HttpServletRequest) request;
//
//        List<Map<String, Comment>> list;
//        list = courseService.getComment(Integer.parseInt(course_id));
//
//        return list;
//    }
//
//    @PostMapping("/course/setComment")
//    public R<Object> setComment(@RequestBody Comment comment) {
//        courseService.setComment(comment);
//        log.info("存入新事项：{}", comment.getComment_text());
//
//        return R.success(null);
//    }

    //    获取某一门课程的评论Evaluation
    @GetMapping("/course/getEvaluation")
    public List<Map<String, Evaluation>> getEvaluation(@RequestParam("course_id") String course_id, ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;

        List<Map<String, Evaluation>> list;
        list = courseService.getEvaluation(Integer.parseInt(course_id));


        return list;
    }

    @PostMapping("/course/setEvaluation")
    public R<Object> setEvaluation(@RequestBody Evaluation evaluation) {
        courseService.setEvaluation(evaluation);
        log.info("存入新事项：{}", evaluation.getEvaluation_text());

        return R.success(null);
    }

    //    获取某一门课程的评论Notice
    @GetMapping("/course/getNotice")
    public List<Map<String, Notice>> getNotice(@RequestParam("course_id") String course_id, ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;

        List<Map<String, Notice>> list;
        list = courseService.getNotice(Integer.parseInt(course_id));

        log.info(list.toString());

        return list;
    }

    @PostMapping("/course/setNotice")
    public R<Object> setNotice(@RequestBody Notice notice) {
        courseService.setNotice(notice);
        log.info("存入新事项：{}", notice.getNotice_title());

        return R.success(null);
    }

    //    获取某一门课程的章节Chapter
    @GetMapping("/course/getChapter")
    public List<Map<String, Chapter>> getChapter(@RequestParam("course_id") String course_id, ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;

        List<Map<String, Chapter>> list;
        list = courseService.getChapter(Integer.parseInt(course_id));


        return list;
    }

    @PostMapping("/course/setFileData")
    public R<Object> setFileData(@RequestBody FileData fileData) {
        courseService.setFileData(fileData);
        log.info("存入新事项：{}", fileData.getFile_name());

        return R.success(null);
    }

    //    获取某一门课程的章节Chapter
    @GetMapping("/course/getFileData")
    public List<Map<String, FileData>> getFileData(@RequestParam("course_id") String course_id, ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;

        List<Map<String, FileData>> list;
        list = courseService.getFileData(Integer.parseInt(course_id));


        return list;
    }
}
