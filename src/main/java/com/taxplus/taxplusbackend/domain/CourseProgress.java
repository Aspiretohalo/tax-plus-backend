package com.taxplus.taxplusbackend.domain;

import jakarta.persistence.*;

@Table(name = "courseprogress")
@Entity
public class CourseProgress {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long course_id;
    private long student_id;
    private float course_learning_progress;
    private boolean badge_got;
    private int confirmation_time;

    public int getConfirmation_time() {
        return confirmation_time;
    }

    public void setConfirmation_time(int confirmation_time) {
        this.confirmation_time = confirmation_time;
    }

    public long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(long course_id) {
        this.course_id = course_id;
    }

    public long getStudent_id() {
        return student_id;
    }

    public void setStudent_id(long student_id) {
        this.student_id = student_id;
    }

    public float getCourse_learning_progress() {
        return course_learning_progress;
    }

    public void setCourse_learning_progress(float course_learning_progress) {
        this.course_learning_progress = course_learning_progress;
    }

    public boolean isBadge_got() {
        return badge_got;
    }

    public void setBadge_got(boolean badge_got) {
        this.badge_got = badge_got;
    }
}
