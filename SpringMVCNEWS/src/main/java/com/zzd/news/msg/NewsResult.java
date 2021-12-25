package com.zzd.news.msg;

import com.zzd.news.pojo.NewsDict;

import java.util.List;


public class NewsResult {
    private int code;
    private String info;
    private List<NewsDict> msg;

    public NewsResult(int code, String info, List<NewsDict> msg) {
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

    public List<NewsDict> getMsg() {
        return msg;
    }

    public void setMsg(List<NewsDict> msg) {
        this.msg = msg;
    }
}
