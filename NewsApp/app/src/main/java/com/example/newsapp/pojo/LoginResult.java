package com.example.newsapp.pojo;

public class LoginResult {
    private int code;
    private String info;
    private String msg;

    public LoginResult(int code, String info, String msg) {
        this.code = code;
        this.info = info;
        this.msg = msg;
    }

    public LoginResult() {
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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
