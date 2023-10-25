package com.taxplus.taxplusbackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.taxplus.taxplusbackend.domain.Chapter;
import org.apache.ibatis.annotations.Select;

public interface ChapterMapper extends BaseMapper<Chapter>{

    @Select(value = "INSERT INTO chapter (video_title, course_id, file_id, psign, courseware_url, chapter_index) SELECT #{video_title}, #{course_id}, #{file_id}, #{psign}, #{courseware_url}, COALESCE(MAX(chapter_index), 0) + 1 FROM chapter WHERE course_id = #{course_id};")
    void setChapter(Chapter chapter);

}
