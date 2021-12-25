package com.zzd.news.msg;

import com.zzd.news.pojo.NewsUser;

public class InfoResult {
    private int code;
    private String info;
    private NewsUser newsUser;

    public InfoResult(NewsUser newsUser) {
        this.code = 200;
        this.info = "success";
        this.newsUser = newsUser;
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

    public NewsUser getNewsUser() {
        return newsUser;
    }

    public void setNewsUser(NewsUser newsUser) {
        this.newsUser = newsUser;
    }
}
