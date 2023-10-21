package com.taxplus.taxplusbackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.taxplus.taxplusbackend.domain.Course;
import com.taxplus.taxplusbackend.domain.Video;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

public interface VideoMapper extends BaseMapper<Video>{

//    @Select (value = "Select * from videos where video_id = #{video_id}")
//    Video selectonevideo(Video video);

    @Select(value = "insert into videos (video_title,course_id,file_id,psign) values(#{video_title},#{course_id},#{file_id},#{psign})")
    void setVideo(Video video);

}
