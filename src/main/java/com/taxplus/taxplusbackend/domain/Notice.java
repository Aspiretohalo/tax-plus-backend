package com.taxplus.taxplusbackend.domain;

import jakarta.persistence.*;

import java.util.Date;

@Table(name = "notices")
@Entity
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long notice_id;
    private int course_id;
    private int announcer;
    private String notice_title;
    private String notice_text;
    private Date notice_time;

    public long getNotice_id() {
        return notice_id;
    }

    public void setNotice_id(long notice_id) {
        this.notice_id = notice_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public int getAnnouncer() {
        return announcer;
    }

    public void setAnnouncer(int announcer) {
        this.announcer = announcer;
    }

    public String getNotice_title() {
        return notice_title;
    }

    public void setNotice_title(String notice_title) {
        this.notice_title = notice_title;
    }

    public String getNotice_text() {
        return notice_text;
    }

    public void setNotice_text(String notice_text) {
        this.notice_text = notice_text;
    }

    public Date getNotice_time() {
        return notice_time;
    }

    public void setNotice_time(Date notice_time) {
        this.notice_time = notice_time;
    }
}
