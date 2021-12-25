package com.zzd.news.msg;

import com.zzd.news.pojo.NewsComment;
import com.zzd.news.pojo.NewsDict;

import java.util.List;


public class CommentResult {
    private int code;
    private String info;
    private List<NewsComment> msg;

    public CommentResult(int code, String info, List<NewsComment> msg) {
        this.code = code;
        this.info = info;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public List<NewsComment> getMsg() {
        return msg;
    }

    public void setMsg(List<NewsComment> msg) {
        this.msg = msg;
    }
}
