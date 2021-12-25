package com.zzd.news.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.TypeReference;
import com.zzd.news.msg.CommentResult;
import com.zzd.news.msg.NewsResult;
import com.zzd.news.pojo.NewsComment;
import com.zzd.news.pojo.NewsDict;
import com.zzd.news.service.CommentService;
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
public class CommentController {
    @Autowired
    UserService userService;

    @Autowired
    CommentService commentService;

    @ResponseBody
    @RequestMapping("/getComment")
    public String getComment(HttpServletRequest request){
        String token_session = request.getParameter("token_session");
        if(userService.judgeToken(token_session)){
            List<NewsComment> list = commentService.getComments();
            return JSON.toJSONString(new CommentResult(200,"success", list));
        }else{
            return JSON.toJSONString(new CommentResult(0,"error",null));
        }
    }
    @ResponseBody
    @RequestMapping("/upLoadComment")
    public String upLoadComment(@RequestParam String token_session,@RequestParam String commentJson){
        if(userService.judgeToken(token_session)){
            commentService.upLoadComment(JSON.parseObject(commentJson, new TypeReference<NewsComment>() {}));
            List<NewsComment> list = commentService.getComments();
            return JSON.toJSONString(new CommentResult(200,"success", list));
        }else{
            return JSON.toJSONString(new CommentResult(0,"error",null));
        }
    }
}
