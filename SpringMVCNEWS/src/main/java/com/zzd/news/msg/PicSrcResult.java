package com.zzd.news.msg;

public class PicSrcResult {
    private int code;
    private String info;
    private String [] picurl;

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

    public String[] getPicurl() {
        return picurl;
    }

    public void setPicurl(String[] picurl) {
        this.picurl = picurl;
    }

    public PicSrcResult(int code, String info, String [] picurl) {
        this.code = code;
        this.info = info;
        this.picurl = picurl;
    }

}
