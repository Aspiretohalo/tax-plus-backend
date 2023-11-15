package com.taxplus.taxplusbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.taxplus.taxplusbackend.domain.*;
import com.taxplus.taxplusbackend.mapper.CourseMapper;
import com.taxplus.taxplusbackend.mapper.StudentMapper;
import com.taxplus.taxplusbackend.service.CourseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;

import static com.taxplus.taxplusbackend.utils.SimilarityBasedSort.calculateJaccardSimilarity;

@Slf4j
@Service
public class CourseServiceImpl extends ServiceImpl<CourseMapper, Course> implements CourseService {
    @Autowired
    private CourseMapper courseMapper;
    @Autowired
    private StudentMapper studentMapper;

    @Override
    public List<Map<String, Course>> getRecommendedCourse(int student_id) {
        List<Map<String, Course>> resultArray = courseMapper.getAllCourses();
        if (resultArray == null) {
            return null;
        }

//        拿到了course_label
        List<String[]> courseLabelsList = new ArrayList<>();
        for (Map<String, Course> courseMap : resultArray) {
            String str = String.valueOf(courseMap.get("course_label"));
            String[] courseLabel = str.substring(1).substring(0, str.length() - 2).split(",");
            courseLabelsList.add(courseLabel);
        }
//        log.info(Arrays.toString(courseLabelsList.get(0)));
//        拿到了course_intendencies
        String str1 = studentMapper.getCourseIntendencies(student_id);
        String courseIntendencies = str1.substring(1).substring(0, str1.length() - 2);

        String[] arr1 = courseIntendencies.split(","); // 假设课程兴趣是以逗号分隔的字符串

//        log.info("arr");
//        log.info(Arrays.toString(arr1));
//        每一门课程的标签同课程偏好作比较
        Map<String[], Double> similarityMap = new HashMap<>();
        for (String[] arr : courseLabelsList) {
            double similarity = calculateJaccardSimilarity(arr1, arr);
            similarityMap.put(arr, similarity);
        }

        List<Map.Entry<String[], Double>> sortedList = new ArrayList<>(similarityMap.entrySet());
        sortedList.sort((entry1, entry2) -> Double.compare(entry2.getValue(), entry1.getValue()));
//        打印相似度
        for (Map.Entry<String[], Double> entry : sortedList) {
            System.out.println(Arrays.toString(entry.getKey()) + " - Similarity: " + entry.getValue());
        }
        // 创建新的列表，按照排序后的相似度顺序将相应的课程放入其中
//        List<Map<String, Course>> sortedCourses = new ArrayList<>();
//        for (Map.Entry<String[], Double> entry : sortedList) {
//            // 获取相应的课程信息
//            Map<String, Course> courseMap = getCourseByLabel(resultArray, entry.getKey());
//            sortedCourses.add(courseMap);
//        }

        // 创建新的列表，选择排序完的前五个课程
        List<Map<String, Course>> sortedCourses = new ArrayList<>();
        int count = 0;
        for (Map.Entry<String[], Double> entry : sortedList) {
            // 获取相应的课程信息
            Map<String, Course> courseMap = getCourseByLabel(resultArray, entry.getKey());
            sortedCourses.add(courseMap);

            // 限制只选择前五个课程
            count++;
            if (count >= 5) {
                break;
            }
        }
        // 输出排序后的课程
        for (Map<String, Course> courseMap : sortedCourses) {
            System.out.println("Course: " + courseMap);
        }

        log.info(sortedCourses.toString());
        return sortedCourses;
    }

    // 辅助方法，根据标签获取对应的课程信息
    private Map<String, Course> getCourseByLabel(List<Map<String, Course>> courses, String[] labels) {
        for (Map<String, Course> courseMap : courses) {
            String str = String.valueOf(courseMap.get("course_label"));
            String[] courseLabels = str.substring(1).substring(0, str.length() - 2).split(",");

            // 判断标签是否一致
            if (Arrays.equals(courseLabels, labels)) {
                return courseMap;
            }
        }
        return null;
    }

    @Override
    public List<Map<String, Course>> getCourseByStudentId(int student_id) {
        List<Map<String, Course>> resultArray = courseMapper.getCourseByStudentId(student_id);
        if (resultArray == null) {
            return null;
        }
        log.info(String.valueOf(resultArray));

        return resultArray;
    }

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
