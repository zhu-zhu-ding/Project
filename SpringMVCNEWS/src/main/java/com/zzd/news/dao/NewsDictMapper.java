package com.zzd.news.dao;

import com.zzd.news.pojo.NewsDict;
import com.zzd.news.pojo.NewsDictExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NewsDictMapper {
    long countByExample(NewsDictExample example);

    int deleteByExample(NewsDictExample example);

    int deleteByPrimaryKey(Integer newsId);

    int insert(NewsDict record);

    int insertSelective(NewsDict record);

    List<NewsDict> selectByExample(NewsDictExample example);

    NewsDict selectByPrimaryKey(Integer newsId);

    int updateByExampleSelective(@Param("record") NewsDict record, @Param("example") NewsDictExample example);

    int updateByExample(@Param("record") NewsDict record, @Param("example") NewsDictExample example);

    int updateByPrimaryKeySelective(NewsDict record);

    int updateByPrimaryKey(NewsDict record);
}