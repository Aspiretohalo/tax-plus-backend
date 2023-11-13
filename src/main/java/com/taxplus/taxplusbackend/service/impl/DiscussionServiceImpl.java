package com.taxplus.taxplusbackend.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.taxplus.taxplusbackend.domain.Discussion;
import com.taxplus.taxplusbackend.domain.SubDiscussion;
import com.taxplus.taxplusbackend.mapper.DiscussionMapper;
import com.taxplus.taxplusbackend.service.DiscussionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class DiscussionServiceImpl extends ServiceImpl<DiscussionMapper, Discussion> implements DiscussionService {
    @Autowired(required = false)
    private DiscussionMapper discussionMapper;

    @Override
    public List<Map<String, Discussion>> getDiscussion() {
        List<Map<String, Discussion>> resultArray = discussionMapper.getDiscussion();

        if (resultArray == null) {
//            "请求的数据不存在"
            return null;
        }
        log.info(String.valueOf(resultArray));

        return resultArray;
    }

    @Override
    public void setDiscussion(Discussion discussion) {
        discussionMapper.setDiscussion(discussion);
    }

    @Override
    public List<Map<String, SubDiscussion>> getSubDiscussion() {
        List<Map<String, SubDiscussion>> resultArray = discussionMapper.getSubDiscussion();

        if (resultArray == null) {
            return null;
        }
        log.info(String.valueOf(resultArray));

        return resultArray;
    }

    @Override
    public void setSubDiscussion(SubDiscussion subDiscussion) {
        discussionMapper.setSubDiscussion(subDiscussion);
    }
}
