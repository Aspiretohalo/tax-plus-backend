package com.taxplus.taxplusbackend.domain;

import jakarta.persistence.*;

import java.util.Date;

@Table(name = "students")
@Entity
public class Student {
    // 注意属性名要与数据表中的字段名一致
    // 主键自增int(10)对应long
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long student_id;

    private String student_name;

    private String phone_number;

    private String user_password;

    private String avatar;

    private int gender;
    private String email;

    private float totalLearningTime;
    private String available_time;
    private String course_intendencies;
    private int integral;
    public String jwt;

    public String getAvailable_time() {
        return available_time;
    }

    public void setAvailable_time(String available_time) {
        this.available_time = available_time;
    }

    public String getCourse_intendencies() {
        return course_intendencies;
    }

    public void setCourse_intendencies(String course_intendencies) {
        this.course_intendencies = course_intendencies;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }

    public long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(long student_id) {
        this.student_id = student_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }

    public String getPhone_number() {
        return phone_number;
    }

    public void setPhone_number(String phone_number) {
        this.phone_number = phone_number;
    }

    public String getUser_password() {
        return user_password;
    }

    public void setUser_password(String user_password) {
        this.user_password = user_password;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getIntegral() {
        return integral;
    }

    public void setIntegral(int integral) {
        this.integral = integral;
    }

    public float getTotalLearningTime() {
        return totalLearningTime;
    }

    public void setTotalLearningTime(float totalLearningTime) {
        this.totalLearningTime = totalLearningTime;
    }
}
