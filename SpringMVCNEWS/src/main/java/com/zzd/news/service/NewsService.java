package com.zzd.news.service;

import com.zzd.news.msg.SuccessResult;
import com.zzd.news.pojo.NewsDict;

import java.util.List;

public interface NewsService {
    List<NewsDict> getNews () ;
    SuccessResult deleteNews(Integer id);
    SuccessResult updateNews(Integer id,NewsDict newsDict);
    SuccessResult insertNews(NewsDict newsDict);
}
