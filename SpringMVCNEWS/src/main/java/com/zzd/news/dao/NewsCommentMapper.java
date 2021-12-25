package com.zzd.news.dao;

import com.zzd.news.pojo.NewsComment;
import com.zzd.news.pojo.NewsCommentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NewsCommentMapper {
    long countByExample(NewsCommentExample example);

    int deleteByExample(NewsCommentExample example);

    int deleteByPrimaryKey(Integer commentId);

    int insert(NewsComment record);

    int insertSelective(NewsComment record);

    List<NewsComment> selectByExample(NewsCommentExample example);

    NewsComment selectByPrimaryKey(Integer commentId);

    int updateByExampleSelective(@Param("record") NewsComment record, @Param("example") NewsCommentExample example);

    int updateByExample(@Param("record") NewsComment record, @Param("example") NewsCommentExample example);

    int updateByPrimaryKeySelective(NewsComment record);

    int updateByPrimaryKey(NewsComment record);
}