package com.taxplus.taxplusbackend.domain;

import jakarta.persistence.*;

@Table(name = "videos")
@Entity
public class Chapter {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long video_id;

    private String video_title;

    private long course_id;

    private String file_id;
    private String psign;

    private String courseware_url;

    private int chapter_index;
    private float last_watch_time;

    public float getLast_watch_time() {
        return last_watch_time;
    }

    public void setLast_watch_time(float last_watch_time) {
        this.last_watch_time = last_watch_time;
    }

    public int getChapter_index() {
        return chapter_index;
    }

    public void setChapter_index(int chapter_index) {
        this.chapter_index = chapter_index;
    }

    public String getFile_id() {
        return file_id;
    }

    public void setFile_id(String file_id) {
        this.file_id = file_id;
    }

    public String getPsign() {
        return psign;
    }

    public void setPsign(String psign) {
        this.psign = psign;
    }

    public String getCourseware_url() {
        return courseware_url;
    }

    public void setCourseware_url(String courseware_url) {
        this.courseware_url = courseware_url;
    }

    public long getVideo_id() {
        return video_id;
    }

    public void setVideo_id(long video_id) {
        this.video_id = video_id;
    }

    public String getVideo_title() {
        return video_title;
    }

    public void setVideo_title(String video_title) {
        this.video_title = video_title;
    }

    public long getCourse_id() {
        return course_id;
    }

    public void setCourse_id(long course_id) {
        this.course_id = course_id;
    }


}
