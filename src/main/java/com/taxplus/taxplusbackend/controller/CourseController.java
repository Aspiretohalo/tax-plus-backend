package com.taxplus.taxplusbackend.controller;

import com.taxplus.taxplusbackend.common.R;
import com.taxplus.taxplusbackend.domain.Course;
import com.taxplus.taxplusbackend.service.CourseService;
import com.taxplus.taxplusbackend.utils.JwtUtils;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping
public class CourseController {
    @Autowired
    private CourseService courseService;

    @GetMapping("/getCourses")
    public List<Map<String, Course>> getCourses(@RequestParam("student_id") String student_id, ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;

        List<Map<String, Course>> list;
        list = courseService.getCourses(Integer.parseInt(student_id));


        return list;
    }
}
