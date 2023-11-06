package com.taxplus.taxplusbackend.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.taxplus.taxplusbackend.domain.Discussion;
import com.taxplus.taxplusbackend.domain.SubDiscussion;

import java.util.List;
import java.util.Map;

public interface DiscussionService extends IService<Discussion> {
    List<Map<String, Discussion>> getDiscussion();

    void setDiscussion(Discussion discussion);

    List<Map<String, SubDiscussion>> getSubDiscussion();

    void setSubDiscussion(SubDiscussion subDiscussion);
}
