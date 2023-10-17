package com.taxplus.taxplusbackend.controller;

import com.taxplus.taxplusbackend.common.R;
import com.taxplus.taxplusbackend.domain.Teacher;
import com.taxplus.taxplusbackend.service.TeacherService;
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
@RequestMapping("/teacher")
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    //    接收前端发来的login请求
    @PostMapping("/login")
    public R<Teacher> login(HttpServletRequest request, @RequestBody Teacher teacher) {

        Teacher aUser = new Teacher();

        aUser.setPhone_number(teacher.getPhone_number());
        aUser.setUser_password(teacher.getUser_password());
        if (teacherService.selectTeacher(aUser) == null) {
            return R.error("账号或密码错误");
        }
        Map<String, Object> claims = new HashMap<>();
        claims.put("teacher_id", teacherService.selectTeacher(aUser).getTeacher_id());
        claims.put("phone_number", teacherService.selectTeacher(aUser).getPhone_number());
        claims.put("student_name", teacherService.selectTeacher(aUser).getTeacher_name());

        String jwt = JwtUtils.generateJwt(claims);
        aUser.setJwt(jwt);

        return R.success(aUser);

    }



}