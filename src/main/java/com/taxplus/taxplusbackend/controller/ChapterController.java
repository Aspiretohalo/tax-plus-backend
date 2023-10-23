package com.taxplus.taxplusbackend.controller;

import com.taxplus.taxplusbackend.common.R;
import com.taxplus.taxplusbackend.domain.Chapter;
import com.taxplus.taxplusbackend.service.ChapterService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping
public class ChapterController {
    @Autowired
    private ChapterService chapterService;

    @PostMapping("/teacher/setChapter")
    public R<Object> setChapter(@RequestBody Chapter chapter) {
        chapterService.setChapter(chapter);
        log.info("存入新章节：{}", chapter.getVideo_title());

        return R.success(null);
    }


}
