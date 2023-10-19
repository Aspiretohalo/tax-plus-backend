package com.taxplus.taxplusbackend.domain;

import jakarta.persistence.*;

import java.util.Date;

@Table(name = "Evaluations")
@Entity
public class Evaluation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long evaluation_id;
    private int course_id;
    private String evaluator;
    private int evaluation_stars;
    private String evaluation_text;
    private Date evaluation_time;

    public long getEvaluation_id() {
        return evaluation_id;
    }

    public void setEvaluation_id(long evaluation_id) {
        this.evaluation_id = evaluation_id;
    }

    public int getCourse_id() {
        return course_id;
    }

    public void setCourse_id(int course_id) {
        this.course_id = course_id;
    }

    public String getEvaluator() {
        return evaluator;
    }

    public void setEvaluator(String evaluator) {
        this.evaluator = evaluator;
    }

    public int getEvaluation_stars() {
        return evaluation_stars;
    }

    public void setEvaluation_stars(int evaluation_stars) {
        this.evaluation_stars = evaluation_stars;
    }

    public String getEvaluation_text() {
        return evaluation_text;
    }

    public void setEvaluation_text(String evaluation_text) {
        this.evaluation_text = evaluation_text;
    }

    public Date getEvaluation_time() {
        return evaluation_time;
    }

    public void setEvaluation_time(Date evaluation_time) {
        this.evaluation_time = evaluation_time;
    }
}
