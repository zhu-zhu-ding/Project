package com.zzd.news.pojo;

public class NewsDict {
    private Integer newsId;

    private String newsTitle;

    private String newsText;

    private String newsPublisher;

    private String newsImg;

    public NewsDict(Integer newsId, String newsTitle, String newsText, String newsPublisher, String newsImg) {
        this.newsId = newsId;
        this.newsTitle = newsTitle;
        this.newsText = newsText;
        this.newsPublisher = newsPublisher;
        this.newsImg = newsImg;
    }

    public NewsDict() {
        super();
    }

    public Integer getNewsId() {
        return newsId;
    }

    public void setNewsId(Integer newsId) {
        this.newsId = newsId;
    }

    public String getNewsTitle() {
        return newsTitle;
    }

    public void setNewsTitle(String newsTitle) {
        this.newsTitle = newsTitle == null ? null : newsTitle.trim();
    }

    public String getNewsText() {
        return newsText;
    }

    public void setNewsText(String newsText) {
        this.newsText = newsText == null ? null : newsText.trim();
    }

    public String getNewsPublisher() {
        return newsPublisher;
    }

    public void setNewsPublisher(String newsPublisher) {
        this.newsPublisher = newsPublisher == null ? null : newsPublisher.trim();
    }

    public String getNewsImg() {
        return newsImg;
    }

    public void setNewsImg(String newsImg) {
        this.newsImg = newsImg == null ? null : newsImg.trim();
    }
}