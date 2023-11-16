package com.taxplus.taxplusbackend.controller;

import com.taxplus.taxplusbackend.common.R;
import com.taxplus.taxplusbackend.domain.Discussion;
import com.taxplus.taxplusbackend.domain.SubDiscussion;
import com.taxplus.taxplusbackend.service.DiscussionService;
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
public class DiscussionController {
    @Autowired
    private DiscussionService discussionService;

    @GetMapping("/getDiscussion")
    public List<Map<String, Discussion>> getDiscussion(ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;

        List<Map<String, Discussion>> list;
        list = discussionService.getDiscussion();

        return list;
    }

    @PostMapping("/setDiscussion")
    public R<Object> setDiscussion(@RequestBody Discussion discussion) {
        discussionService.setDiscussion(discussion);
        log.info("存入：{}", discussion.getPost_text());
        log.info("存入：{}", discussion.getPost_time());

        return R.success(null);
    }

    @GetMapping("/getSubDiscussion")
    public List<Map<String, SubDiscussion>> getSubDiscussion(ServletRequest request, ServletResponse response) {
        HttpServletRequest req = (HttpServletRequest) request;

        List<Map<String, SubDiscussion>> list;
        list = discussionService.getSubDiscussion();

        return list;
    }

    @PostMapping("/setSubDiscussion")
    public R<Object> setSubDiscussion(@RequestBody SubDiscussion subDiscussion) {
        discussionService.setSubDiscussion(subDiscussion);
        log.info("存入新事项：{}", subDiscussion.getPost_text());

        return R.success(null);
    }

}
