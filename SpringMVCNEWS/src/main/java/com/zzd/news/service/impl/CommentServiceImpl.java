package com.zzd.news.service.impl;

import com.zzd.news.dao.NewsCommentMapper;
import com.zzd.news.dao.NewsDictMapper;
import com.zzd.news.dao.NewsUserMapper;
import com.zzd.news.pojo.NewsComment;
import com.zzd.news.pojo.NewsDict;
import com.zzd.news.pojo.NewsUserExample;
import com.zzd.news.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    NewsCommentMapper mapper;

    @Autowired
    NewsUserMapper userMapper;

    @Override
    public List<NewsComment> getComments() {
        return mapper.selectByExample(null);
    }

    @Override
    public List<NewsComment> upLoadComment(NewsComment newsComment) {
        NewsUserExample newsUserExample = new NewsUserExample();
        NewsUserExample.Criteria criteria = newsUserExample.createCriteria();
        criteria.andTokenSessionEqualTo(newsComment.getCommentPublisher());
        newsComment.setCommentPublisher(userMapper.selectByExample(newsUserExample).get(0).getUserName());
        mapper.insert(newsComment);
        return mapper.selectByExample(null);
    }

}
