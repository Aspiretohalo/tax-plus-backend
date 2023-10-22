package com.taxplus.taxplusbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.taxplus.taxplusbackend.domain.Chapter;
import com.taxplus.taxplusbackend.mapper.ChapterMapper;
import com.taxplus.taxplusbackend.service.ChapterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ChapterServiceImpl extends ServiceImpl<ChapterMapper, Chapter> implements ChapterService {
    @Autowired(required = false)
    private ChapterMapper chapterMapper;

    @Override
    public void setChapter(Chapter chapter) {
        chapterMapper.setChapter(chapter);
    }


}
