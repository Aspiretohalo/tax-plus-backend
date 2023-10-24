package com.taxplus.taxplusbackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.taxplus.taxplusbackend.domain.Chapter;
import org.apache.ibatis.annotations.Select;

public interface ChapterMapper extends BaseMapper<Chapter>{

    @Select(value = "insert into chapter (video_title,course_id,file_id,psign,courseware_url,chapter_index) values(#{video_title},#{course_id},#{file_id},#{psign},#{courseware_url},#{chapter_index})")
    void setChapter(Chapter chapter);

}
