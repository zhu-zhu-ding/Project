package com.zzd.news.service;

import com.zzd.news.pojo.NewsComment;
import com.zzd.news.pojo.NewsDict;

import java.util.List;

public interface CommentService {
    List<NewsComment> getComments () ;
    List<NewsComment> upLoadComment(NewsComment newsComment);
}
