package com.zzd.news.dao;

import com.zzd.news.pojo.NewsUser;
import com.zzd.news.pojo.NewsUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface NewsUserMapper {
    long countByExample(NewsUserExample example);

    int deleteByExample(NewsUserExample example);

    int deleteByPrimaryKey(Integer userId);

    int insert(NewsUser record);

    int insertSelective(NewsUser record);

    List<NewsUser> selectByExample(NewsUserExample example);

    NewsUser selectByPrimaryKey(Integer userId);

    int updateByExampleSelective(@Param("record") NewsUser record, @Param("example") NewsUserExample example);

    int updateByExample(@Param("record") NewsUser record, @Param("example") NewsUserExample example);

    int updateByPrimaryKeySelective(NewsUser record);

    int updateByPrimaryKey(NewsUser record);
}