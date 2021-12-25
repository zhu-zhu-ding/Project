package com.zzd.news.msg;

public class ErrorResult {
    private int code;
    private String info;
    private String msg;

    public ErrorResult(String msg) {
        this.code = 0;
        this.info = "error";
        this.msg = msg;
    }
}
