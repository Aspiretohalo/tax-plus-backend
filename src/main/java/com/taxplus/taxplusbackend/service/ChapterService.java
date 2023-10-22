package com.taxplus.taxplusbackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.taxplus.taxplusbackend.domain.Chapter;

public interface ChapterService extends IService<Chapter> {
    void setChapter(Chapter chapter);
}
