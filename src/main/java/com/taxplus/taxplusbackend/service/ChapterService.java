package com.taxplus.taxplusbackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.taxplus.taxplusbackend.domain.Chapter;
import com.taxplus.taxplusbackend.domain.Course;

import java.util.List;
import java.util.Map;

public interface ChapterService extends IService<Chapter> {
    List<Map<String, Chapter>> getLastWatchedTime(int chapter_index);

    void setLastWatchedTime(Chapter chapter);

    void setChapter(Chapter chapter);
}
