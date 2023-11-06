package com.taxplus.taxplusbackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.taxplus.taxplusbackend.domain.Discussion;
import com.taxplus.taxplusbackend.domain.SubDiscussion;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface DiscussionMapper extends BaseMapper<Discussion> {
    @Select(value = "insert into discussion (commentator_name,commentator_type,post_text,post_time,image_url) values(#{commentator_name},#{commentator_type},#{post_text},#{post_time},#{image_url})")
    void setDiscussion(Discussion discussion);

    @Select(value = "SELECT *,CASE WHEN commentator_type = 'student' THEN s.avatar WHEN commentator_type = 'teacher' THEN t.avatar  ELSE NULL  END AS avatar FROM discussion d LEFT JOIN students s ON d.commentator_name = s.student_name AND d.commentator_type = 'student' LEFT JOIN  teachers t ON d.commentator_name = t.teacher_name AND d.commentator_type = 'teacher';")
    List<Map<String, Discussion>> getDiscussion();

    @Select(value = "insert into Sub_Discussion (parent_post_id,commentator_name,commentator_type,post_text,post_time,image_url) values(#{parent_post_id},#{commentator_name},#{commentator_type},#{post_text},#{post_time},#{image_url})")
    void setSubDiscussion(SubDiscussion subDiscussion);

    @Select(value = "SELECT sd.*,CASE  WHEN sd.commentator_type = 'student' THEN s.avatar WHEN sd.commentator_type = 'teacher' THEN t.avatar ELSE NULL END AS avatar FROM  sub_discussion sd LEFT JOIN  students s ON sd.commentator_name = s.student_name AND sd.commentator_type = 'student' LEFT JOIN  teachers t ON sd.commentator_name = t.teacher_name AND sd.commentator_type = 'teacher';")
    List<Map<String, SubDiscussion>> getSubDiscussion();
}
