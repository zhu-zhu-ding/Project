package com.zzd.news.service.impl;

import com.zzd.news.dao.NewsDictMapper;
import com.zzd.news.msg.SuccessResult;
import com.zzd.news.pojo.NewsDict;
import com.zzd.news.pojo.NewsDictExample;
import com.zzd.news.service.NewsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NewsServiceImpl implements NewsService {
    @Autowired
    NewsDictMapper mapper;
    @Override
    public List<NewsDict> getNews() {
        return mapper.selectByExample(null);
    }

    @Override
    public SuccessResult deleteNews(Integer id) {
        mapper.deleteByPrimaryKey(id);
        return new SuccessResult("删除成功");
    }

    @Override
    public SuccessResult updateNews(Integer id, NewsDict newsDict) {
        NewsDictExample newsDictExample = new NewsDictExample();
        NewsDictExample.Criteria criteria = newsDictExample.createCriteria();
        criteria.andNewsIdEqualTo(id);
        mapper.updateByExampleSelective(newsDict,newsDictExample);
        return new SuccessResult("新增成功");
    }

    @Override
    public SuccessResult insertNews(NewsDict newsDict) {
        mapper.insert(newsDict);
        return new SuccessResult("修改成功");
    }

}
