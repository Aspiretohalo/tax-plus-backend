package com.taxplus.taxplusbackend.domain;

import jakarta.persistence.*;

@Table(name = "replay_info")
@Entity
public class Replay_info {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long replay_id;
    private int course_id;
    private String file_url;
    private String meeting_id;

    public long getReplay_id() {
        return replay_id;
    }

    public void setReplay_id(long replay_id) {
        this.replay_id = replay_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getFile_url() {
        return file_url;
    }

    public void setFile_url(String file_url) {
        this.file_url = file_url;
    }

    public String getMeeting_id() {
        return meeting_id;
    }

    public void setMeeting_id(String meeting_id) {
        this.meeting_id = meeting_id;
    }
}
