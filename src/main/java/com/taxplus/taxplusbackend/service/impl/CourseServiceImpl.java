package com.taxplus.taxplusbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.taxplus.taxplusbackend.domain.*;
import com.taxplus.taxplusbackend.mapper.CourseMapper;
import com.taxplus.taxplusbackend.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {
    @Autowired(required = false)
    private CourseMapper courseMapper;
    @Override
    public List<Map<String, Course>> getAllCourseLearningProgress(int course_id) {
        List<Map<String, Course>> resultArray = courseMapper.getAllCourseLearningProgress(course_id);
        if (resultArray == null) {
            return null;
        }
        log.info(String.valueOf(resultArray));

        return resultArray;
    }
    @Override
    public List<Map<String, Course>> getSubDiscussionNumber(int commentator) {
        List<Map<String, Course>> resultArray = courseMapper.getSubDiscussionNumber(commentator);

        if (resultArray == null) {
            return null;
        }
        log.info(String.valueOf(resultArray));

        return resultArray;
    }
    @Override
    public List<Map<String, Course>> getDiscussionNumber(int commentator) {
        List<Map<String, Course>> resultArray = courseMapper.getDiscussionNumber(commentator);

        if (resultArray == null) {
            return null;
        }
        log.info(String.valueOf(resultArray));

        return resultArray;
    }
    @Override
    public List<Map<String, Course>> getEvaluationNumber(int course_id, int evaluator) {
        List<Map<String, Course>> resultArray = courseMapper.getEvaluationNumber(course_id, evaluator);

        if (resultArray == null) {
            return null;
        }
        log.info(String.valueOf(resultArray));

        return resultArray;
    }

    @Override
    public List<Map<String, Course>> getCourseLearningProgress(int course_id, int student_id) {
        List<Map<String, Course>> resultArray = courseMapper.getCourseLearningProgress(course_id, student_id);

        if (resultArray == null) {
            return null;
        }
        log.info(String.valueOf(resultArray));

        return resultArray;
    }
    @Override
    public void setConfirmationTime(CourseProgress courseProgress) {
        courseMapper.setConfirmationTime(courseProgress);
    }
    @Override
    public void setCourseLearningProgress(CourseProgress courseProgress) {
        courseMapper.setCourseLearningProgress(courseProgress);
    }

    @Override
    public void selectTheCourse(CourseProgress courseProgress) {
        courseMapper.selectTheCourse(courseProgress);
    }

    @Override
    public void createNewLiving(LivingCourse livingCourse) {
        courseMapper.createNewLiving(livingCourse);
    }

    @Override
    public void addMeetingId(LivingCourse livingCourse) {
        courseMapper.addMeetingId(livingCourse);
    }

    @Override
    public List<Map<String, Course>> hasSelected(int course_id, int student_id) {
        List<Map<String, Course>> resultArray = courseMapper.hasSelected(course_id, student_id);

        if (resultArray == null) {
//            "请求的数据不存在"
            return null;
        }
        log.info(String.valueOf(resultArray));

        return resultArray;
    }

    @Override
    public List<Map<String, Course>> getCourses(int student_id) {
        List<Map<String, Course>> resultArray = courseMapper.getCourses(student_id);

        if (resultArray == null) {
//            "请求的数据不存在"
            return null;
        }
        log.info(String.valueOf(resultArray));

        return resultArray;
    }

    @Override
    public List<Map<String, Course>> getCourseByCourseId(int course_id) {
        List<Map<String, Course>> resultArray = courseMapper.getCourseByCourseId(course_id);

        if (resultArray == null) {
//            "请求的数据不存在"
            return null;
        }
        log.info(String.valueOf(resultArray));

        return resultArray;
    }

    @Override
    public List<Map<String, Course>> getTeacherCourses(int teacher_id) {
        List<Map<String, Course>> resultArray = courseMapper.getTeacherCourses(teacher_id);

        if (resultArray == null) {
//            "请求的数据不存在"
            return null;
        }
        log.info(String.valueOf(resultArray));

        return resultArray;
    }

    @Override
    public void setCourse(Course course) {
        course.setStatus("即将开始");
        course.setTag_type("info");
        course.setChoose_amount(0);
        courseMapper.setCourse(course);
    }

    @Override
    public void setEvaluation(Evaluation evaluation) {
        courseMapper.setEvaluation(evaluation);
    }

    @Override
    public void setNotice(Notice notice) {
        courseMapper.setNotice(notice);
    }

    @Override
    public void setFileData(FileData fileData) {
        courseMapper.setFileData(fileData);
    }

    @Override
    public List<Map<String, Course>> getLivingNotice(int course_id) {
        List<Map<String, Course>> resultArray = courseMapper.getLivingNotice(course_id);
        if (resultArray == null) {
            return null;
        }
        log.info(String.valueOf(resultArray));

        return resultArray;
    }

    @Override
    public List<Map<String, Course>> getAllCourses() {
        List<Map<String, Course>> resultArray = courseMapper.getAllCourses();
        if (resultArray == null) {
            return null;
        }
        log.info(String.valueOf(resultArray));

        return resultArray;
    }

    @Override
    public List<Map<String, Course>> getAllLivingCourses() {
        List<Map<String, Course>> resultArray = courseMapper.getAllLivingCourses();
        if (resultArray == null) {
            return null;
        }
        log.info(String.valueOf(resultArray));

        return resultArray;
    }

    @Override
    public List<Map<String, Evaluation>> getEvaluation(int course_id) {
        List<Map<String, Evaluation>> resultArray = courseMapper.getEvaluation(course_id);

        if (resultArray == null) {
//            "请求的数据不存在"
            return null;
        }
        log.info(String.valueOf(resultArray));

        return resultArray;
    }

    @Override
    public List<Map<String, Notice>> getNotice(int course_id) {
        List<Map<String, Notice>> resultArray = courseMapper.getNotice(course_id);

        if (resultArray == null) {
//            "请求的数据不存在"
            return null;
        }
        log.info(String.valueOf(resultArray));

        return resultArray;
    }

    @Override
    public List<Map<String, FileData>> getFileData(int course_id) {
        List<Map<String, FileData>> resultArray = courseMapper.getFileData(course_id);

        if (resultArray == null) {
            return null;
        }
        log.info(String.valueOf(resultArray));

        return resultArray;
    }


    @Override
    public List<Map<String, Chapter>> getChapter(int course_id) {
        List<Map<String, Chapter>> resultArray = courseMapper.getChapter(course_id);

        if (resultArray == null) {
//            "请求的数据不存在"
            return null;
        }
        log.info(String.valueOf(resultArray));

        return resultArray;
    }


}
