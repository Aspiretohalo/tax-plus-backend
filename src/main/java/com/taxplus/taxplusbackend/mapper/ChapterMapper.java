package com.taxplus.taxplusbackend.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.taxplus.taxplusbackend.domain.Chapter;
import com.taxplus.taxplusbackend.domain.Course;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;
@Mapper
public interface ChapterMapper extends BaseMapper<Chapter>{
    @Select(value = "SELECT * FROM chapter WHERE chapter_index = #{chapter_index};")
    List<Map<String, Chapter>> getLastWatchedTime(int chapter_index);
    @Select(value = "update chapter set last_watch_time=#{last_watch_time} where chapter_index=#{chapter_index}")
    void setLastWatchedTime(Chapter chapter);
    @Select(value = "INSERT INTO chapter (video_title, course_id, file_id, psign, courseware_url, chapter_index) SELECT #{video_title}, #{course_id}, #{file_id}, #{psign}, #{courseware_url}, COALESCE(MAX(chapter_index), 0) + 1 FROM chapter WHERE course_id = #{course_id};")
    void setChapter(Chapter chapter);

}
