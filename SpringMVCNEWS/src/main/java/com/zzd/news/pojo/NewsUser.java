package com.zzd.news.pojo;

import java.util.Date;

public class NewsUser {
    private Integer userId;

    private String userCode;

    private String userPassword;

    private String userName;

    private String tokenSession;

    private Date tokenTime;

    public NewsUser(Integer userId, String userCode, String userPassword, String userName, String tokenSession, Date tokenTime) {
        this.userId = userId;
        this.userCode = userCode;
        this.userPassword = userPassword;
        this.userName = userName;
        this.tokenSession = tokenSession;
        this.tokenTime = tokenTime;
    }

    public NewsUser() {
        super();
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserCode() {
        return userCode;
    }

    public void setUserCode(String userCode) {
        this.userCode = userCode == null ? null : userCode.trim();
    }

    public String getUserPassword() {
        return userPassword;
    }

    public void setUserPassword(String userPassword) {
        this.userPassword = userPassword == null ? null : userPassword.trim();
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    public String getTokenSession() {
        return tokenSession;
    }

    public void setTokenSession(String tokenSession) {
        this.tokenSession = tokenSession == null ? null : tokenSession.trim();
    }

    public Date getTokenTime() {
        return tokenTime;
    }

    public void setTokenTime(Date tokenTime) {
        this.tokenTime = tokenTime;
    }
}