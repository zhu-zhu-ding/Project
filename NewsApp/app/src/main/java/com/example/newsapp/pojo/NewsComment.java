package com.example.newsapp.pojo;

public class NewsComment {
    private Integer commentId;

    private String conmmentText;

    private String picUrls;

    private String commentPublisher;

    public NewsComment(Integer commentId, String conmmentText, String picUrls, String commentPublisher) {
        this.commentId = commentId;
        this.conmmentText = conmmentText;
        this.picUrls = picUrls;
        this.commentPublisher = commentPublisher;
    }

    public NewsComment() {
        super();
    }

    public Integer getCommentId() {
        return commentId;
    }

    public void setCommentId(Integer commentId) {
        this.commentId = commentId;
    }

    public String getConmmentText() {
        return conmmentText;
    }

    public void setConmmentText(String conmmentText) {
        this.conmmentText = conmmentText == null ? null : conmmentText.trim();
    }

    public String getPicUrls() {
        return picUrls;
    }

    public void setPicUrls(String picUrls) {
        this.picUrls = picUrls == null ? null : picUrls.trim();
    }

    public String getCommentPublisher() {
        return commentPublisher;
    }

    public void setCommentPublisher(String commentPublisher) {
        this.commentPublisher = commentPublisher == null ? null : commentPublisher.trim();
    }
}