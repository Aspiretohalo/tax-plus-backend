package com.taxplus.taxplusbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.taxplus.taxplusbackend.domain.Chapter;
import com.taxplus.taxplusbackend.domain.Course;
import com.taxplus.taxplusbackend.mapper.ChapterMapper;
import com.taxplus.taxplusbackend.service.ChapterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class ChapterServiceImpl extends ServiceImpl<ChapterMapper, Chapter> implements ChapterService {
    @Autowired
    private ChapterMapper chapterMapper;

    @Override
    public List<Map<String, Chapter>> getLastWatchedTime(int chapter_index) {
        List<Map<String, Chapter>> resultArray = chapterMapper.getLastWatchedTime(chapter_index);

        if (resultArray == null) {
//            "请求的数据不存在"
            return null;
        }
        log.info(String.valueOf(resultArray));

        return resultArray;
    }
    @Override
    public void setLastWatchedTime(Chapter chapter) {
        chapterMapper.setLastWatchedTime(chapter);
    }

    @Override
    public void setChapter(Chapter chapter) {
        chapterMapper.setChapter(chapter);
    }


}
