package com.taxplus.taxplusbackend.domain;

import jakarta.persistence.*;

import java.util.Date;

@Table(name = "living_courses")
@Entity
public class LivingCourse {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long living_course_id;
    private int course_id;
    private String living_course_name;
    private String living_course_description;
    private int course_teacher;
    private String meeting_id;
    private Date start_time;

    public Date getStart_time() {
        return start_time;
    }

    public void setStart_time(Date start_time) {
        this.start_time = start_time;
    }

    public String getMeeting_id() {
        return meeting_id;
    }

    public void setMeeting_id(String meeting_id) {
        this.meeting_id = meeting_id;
    }

    public long getLiving_course_id() {
        return living_course_id;
    }

    public void setLiving_course_id(long living_course_id) {
        this.living_course_id = living_course_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getLiving_course_name() {
        return living_course_name;
    }

    public void setLiving_course_name(String living_course_name) {
        this.living_course_name = living_course_name;
    }

    public String getLiving_course_description() {
        return living_course_description;
    }

    public void setLiving_course_description(String living_course_description) {
        this.living_course_description = living_course_description;
    }

    public int getCourse_teacher() {
        return course_teacher;
    }

    public void setCourse_teacher(int course_teacher) {
        this.course_teacher = course_teacher;
    }
}
