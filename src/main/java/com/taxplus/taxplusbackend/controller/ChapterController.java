package com.taxplus.taxplusbackend.controller;

import com.alibaba.fastjson.JSON;
import com.taxplus.taxplusbackend.common.R;
import com.taxplus.taxplusbackend.domain.Chapter;
import com.taxplus.taxplusbackend.service.ChapterService;
import com.taxplus.taxplusbackend.utils.TcMetaData;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping
public class ChapterController {
    @Autowired
    private TcMetaData tcMetaData;
    @Autowired
    private ChapterService chapterService;


    @PostMapping("/getMediaData")
    public R<Object> getMediaData(@RequestBody Chapter chapter) {
        Object metaData = JSON.parse(tcMetaData.getMediaData(chapter.getFile_id()));
        return R.success(metaData);
    }

    @PostMapping("/teacher/setChapter")
    public R<Object> setChapter(@RequestBody Chapter chapter) {
        chapterService.setChapter(chapter);
        log.info("存入新章节：{}", chapter.getVideo_title());

        return R.success(null);
    }


}
