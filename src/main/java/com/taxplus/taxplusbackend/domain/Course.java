package com.taxplus.taxplusbackend.domain;

import jakarta.persistence.*;

import java.util.Date;

@Table(name = "courses")
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long course_id;

    private String course_name;

    private String course_description;

    private String course_label;

    private String course_url;

    private long course_teacher;

    public long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(long course_id) {
        this.course_id = course_id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_description() {
        return course_description;
    }

    public void setCourse_description(String course_description) {
        this.course_description = course_description;
    }

    public String getCourse_label() {
        return course_label;
    }

    public void setCourse_label(String course_label) {
        this.course_label = course_label;
    }

    public String getCourse_url() {
        return course_url;
    }

    public void setCourse_url(String course_url) {
        this.course_url = course_url;
    }

    public long getCourse_teacher() {
        return course_teacher;
    }

    public void setCourse_teacher(long course_teacher) {
        this.course_teacher = course_teacher;
    }
}
