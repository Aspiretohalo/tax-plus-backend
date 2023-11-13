package com.taxplus.taxplusbackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.taxplus.taxplusbackend.domain.Discussion;
import com.taxplus.taxplusbackend.domain.SubDiscussion;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface DiscussionMapper extends BaseMapper<Discussion> {
    @Select(value = "insert into discussion (commentator,commentator_type,post_text,post_time,image_url) values(#{commentator},#{commentator_type},#{post_text},#{post_time},#{image_url})")
    void setDiscussion(Discussion discussion);

    @Select(value = "SELECT  d.*,  COALESCE(s.avatar, t.avatar) AS avatar, COALESCE(s.student_name, t.teacher_name) AS name FROM  discussion d LEFT JOIN students s ON d.commentator = s.student_id AND d.commentator_type = 'student' LEFT JOIN  teachers t ON d.commentator = t.teacher_id AND d.commentator_type= 'teacher';")
    List<Map<String, Discussion>> getDiscussion();

    @Select(value = "insert into Sub_Discussion (parent_post_id,commentator,commentator_type,post_text,post_time,image_url) values(#{parent_post_id},#{commentator},#{commentator_type},#{post_text},#{post_time},#{image_url})")
    void setSubDiscussion(SubDiscussion subDiscussion);

    @Select(value = "SELECT sd.*, COALESCE(s.avatar, t.avatar) AS avatar, COALESCE(s.student_name, t.teacher_name) AS name FROM sub_discussion sd LEFT JOIN students s ON sd.commentator = s.student_id AND sd.commentator_type = 'student' LEFT JOIN teachers t ON sd.commentator = t.teacher_id AND sd.commentator_type = 'teacher';")
    List<Map<String, SubDiscussion>> getSubDiscussion();
}
