package com.zzd.news.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.zzd.news.msg.ErrorResult;
import com.zzd.news.msg.NewsResult;
import com.zzd.news.msg.SuccessResult;
import com.zzd.news.pojo.NewsComment;
import com.zzd.news.pojo.NewsDict;
import com.zzd.news.service.NewsService;
import com.zzd.news.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.List;


@Controller
public class NewsController {
    @Autowired
    UserService userService;

    @Autowired
    NewsService newsService;

    @ResponseBody
    @RequestMapping("/getnews")
    public String getNews(@RequestParam String token_session){
        if(userService.judgeToken(token_session)){
            List<NewsDict> list = newsService.getNews();
            return JSON.toJSONString(new NewsResult(200,"success", list));
        }else{
            return JSON.toJSONString(new NewsResult(0,"error",null));
        }
    }

    @ResponseBody
    @RequestMapping("/updateNews")
    public String updateNews(@RequestParam String token_session,@RequestParam String id,@RequestParam String NewsDiceJson){
        if(userService.judgeToken(token_session)){
            SuccessResult result = newsService.updateNews(Integer.parseInt(id),JSON.parseObject(NewsDiceJson, new TypeReference<NewsDict>() {}));
            return JSON.toJSONString(result);
        }else{
            return JSON.toJSONString(new ErrorResult("更新失败"));
        }
    }

    @ResponseBody
    @RequestMapping("/deletenews")
    public String deleteNews(@RequestParam String token_session,@RequestParam String id){
        if(userService.judgeToken(token_session)){
            SuccessResult result = newsService.deleteNews(Integer.parseInt(id));
            return JSON.toJSONString(result);
        }else{
            return JSON.toJSONString(new ErrorResult("删除失败"));
        }
    }

    @ResponseBody
    @RequestMapping("/insertnews")
    public String insertNews(@RequestParam String token_session,@RequestParam String NewsDiceJson){
        if(userService.judgeToken(token_session)){
            SuccessResult result = newsService.insertNews(JSON.parseObject(NewsDiceJson, new TypeReference<NewsDict>() {}));
            return JSON.toJSONString(result);
        }else{
            return JSON.toJSONString(new ErrorResult("插入失败"));
        }
    }

}
