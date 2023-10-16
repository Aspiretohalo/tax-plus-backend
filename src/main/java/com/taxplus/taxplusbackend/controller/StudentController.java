package com.taxplus.taxplusbackend.controller;

import com.taxplus.taxplusbackend.common.R;
import com.taxplus.taxplusbackend.domain.Student;
import com.taxplus.taxplusbackend.service.StudentService;
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
@RequestMapping("/student")
public class StudentController {
    @Autowired
    private StudentService studentService;

    //    接收前端发来的login请求
    @PostMapping("/login")
    public R<Student> login(HttpServletRequest request, @RequestBody Student student) {

        Student aUser = new Student();

        aUser.setPhone_number(student.getPhone_number());
        aUser.setUser_password(student.getUser_password());
        if (studentService.selectStudent(aUser) == null) {
            return R.error("账号或密码错误");
        }
        Map<String, Object> claims = new HashMap<>();
        claims.put("student_id", studentService.selectStudent(aUser).getStudent_id());
        claims.put("phone_number", studentService.selectStudent(aUser).getPhone_number());
        claims.put("student_name", studentService.selectStudent(aUser).getStudent_name());

        String jwt = JwtUtils.generateJwt(claims);
        aUser.setJwt(jwt);

        return R.success(aUser);

    }

//    @GetMapping("/msg")
//    public User getMsg(ServletRequest request, ServletResponse response) {
//        HttpServletRequest req = (HttpServletRequest) request;
//
//        User aUser;
//
////        判断收到的jwt有没有bear
//        String jwt = req.getHeader("Authorization");
//        String[] jwt2 = jwt.split(" ");
//        Map<String, Object> claims2;
//
//        if (jwt2.length == 1) {
//            log.info("JWT" + jwt);
//            claims2 = JwtUtils.parseJWT(jwt);
//
////        通过phoneNum来获取数据
//            aUser = userService.getInfo((String) claims2.get("phoneNum"));
//        } else {
//            log.info("JWT" + jwt2[1]);
//
//            claims2 = JwtUtils.parseJWT(jwt2[1]);
//            aUser = userService.getInfo((String) claims2.get("phoneNum"));
//        }
//        return aUser;
//    }
//
//
//    @PutMapping("/user/avatar")
//    public R<Object> updateAvatar(@RequestBody User user) {
//        userService.updateAvatar(user);
//        log.info("更新头像：{}", user.getAvatar());
//
//        return R.success(null);
//    }


}