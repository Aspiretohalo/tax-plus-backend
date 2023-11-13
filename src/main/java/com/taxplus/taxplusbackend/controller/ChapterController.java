package com.taxplus.taxplusbackend.controller;

import com.alibaba.fastjson.JSON;
import com.taxplus.taxplusbackend.common.R;
import com.taxplus.taxplusbackend.domain.Chapter;
import com.taxplus.taxplusbackend.domain.Course;
import com.taxplus.taxplusbackend.service.ChapterService;
import com.taxplus.taxplusbackend.utils.TcMetaData;
import jakarta.servlet.ServletRequest;
import jakarta.servlet.ServletResponse;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping
public class ChapterController {
    @Autowired
    private TcMetaData tcMetaData;
    @Autowired
    private ChapterService chapterService;
    @GetMapping("/getLastWatchedTime")
    public List<Map<String, Chapter>> getLastWatchedTime(@RequestParam("chapter_index") String chapter_index, ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;

        List<Map<String, Chapter>> list;
        list = chapterService.getLastWatchedTime(Integer.parseInt(chapter_index));
        return list;
    }
    @PostMapping("/setLastWatchedTime")
    public R<Object> setLastWatchedTime(@RequestBody Chapter chapter) {
        chapterService.setLastWatchedTime(chapter);
        log.info("存入新章节：{}", chapter.getLast_watch_time());

        return R.success(null);
    }


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
