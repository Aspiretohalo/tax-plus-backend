package com.taxplus.taxplusbackend.domain;

import jakarta.persistence.*;

import java.util.Date;

@Table(name = "sub_discussion")
@Entity
public class SubDiscussion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long post_id;
    private int parent_post_id;
    private String commentator_name;
    private String commentator_type;
    private String post_text;
    private Date post_time;
    private String image_url;

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public long getPost_id() {
        return post_id;
    }

    public void setPost_id(long post_id) {
        this.post_id = post_id;
    }

    public int getParent_post_id() {
        return parent_post_id;
    }

    public void setParent_post_id(int parent_post_id) {
        this.parent_post_id = parent_post_id;
    }

    public String getCommentator_name() {
        return commentator_name;
    }

    public void setCommentator_name(String commentator_name) {
        this.commentator_name = commentator_name;
    }

    public String getCommentator_type() {
        return commentator_type;
    }

    public void setCommentator_type(String commentator_type) {
        this.commentator_type = commentator_type;
    }

    public String getPost_text() {
        return post_text;
    }

    public void setPost_text(String post_text) {
        this.post_text = post_text;
    }

    public Date getPost_time() {
        return post_time;
    }

    public void setPost_time(Date post_time) {
        this.post_time = post_time;
    }
}
