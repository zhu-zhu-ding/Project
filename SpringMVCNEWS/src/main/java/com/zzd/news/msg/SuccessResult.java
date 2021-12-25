package com.zzd.news.msg;

public class SuccessResult {
    private int code;
    private String info;
    private String msg;

    public SuccessResult(String msg) {
        this.code = 200;
        this.info = "success";
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

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
