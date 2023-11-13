package com.taxplus.taxplusbackend.controller;

import com.taxplus.taxplusbackend.common.R;
import com.taxplus.taxplusbackend.domain.Course;
import com.taxplus.taxplusbackend.domain.Student;
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
@RequestMapping
//@CrossOrigin(origins = {"http://localhost:5173"})
public class TeacherController {
    @Autowired
    private TeacherService teacherService;

    //    接收前端发来的login请求
    @PostMapping("/teacher/login")
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
        log.info(jwt);

        return R.success(aUser);

    }

    //    通过手机号来判断是哪个老师
    @GetMapping("/getTeacherMsg")
    public Teacher getTeacherMsg(ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;

        Teacher aUser;

//        判断收到的jwt有没有bear
        String jwt = req.getHeader("Authorization");
        String[] jwt2 = jwt.split(" ");
        Map<String, Object> claims2;

        if (jwt2.length == 1) {
            log.info("JWT" + jwt);
            claims2 = JwtUtils.parseJWT(jwt);
//        通过phoneNum来获取数据
            aUser = teacherService.getInfo((String) claims2.get("phone_number"));
        } else {
            log.info("JWT" + jwt2[1]);
            claims2 = JwtUtils.parseJWT(jwt2[1]);
            aUser = teacherService.getInfo((String) claims2.get("phone_number"));
        }
        return aUser;
    }


}