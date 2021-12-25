package com.example.newsapp.pojo;

import java.util.List;

/**
 * @program: NewsApp
 * @description:
 * @author: zzd
 * @create: 2021-12-24 00:05
 **/
public class CommentItem {

    /**
     * code : 200
     * info : success
     * msg : [{"commentId":1,"commentPublisher":"admin","conmmentText":"这是第一个","picUrls":"http://192.168.2.141:8086/picShow/e536b0b2-5d18-4340-8897-8173a4111b27.jpg,http://192.168.2.141:8086/picShow/e536b0b2-5d18-4340-8897-8173a4111b27.jpg"}]
     */

    private int code;
    private String info;
    private List<MsgBean> msg;

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

    public List<MsgBean> getMsg() {
        return msg;
    }

    public void setMsg(List<MsgBean> msg) {
        this.msg = msg;
    }

    public static class MsgBean {
        /**
         * commentId : 1
         * commentPublisher : admin
         * conmmentText : 这是第一个
         * picUrls : http://192.168.2.141:8086/picShow/e536b0b2-5d18-4340-8897-8173a4111b27.jpg,http://192.168.2.141:8086/picShow/e536b0b2-5d18-4340-8897-8173a4111b27.jpg
         */

        private int commentId;
        private String commentPublisher;
        private String conmmentText;
        private String picUrls;

        public int getCommentId() {
            return commentId;
        }

        public void setCommentId(int commentId) {
            this.commentId = commentId;
        }

        public String getCommentPublisher() {
            return commentPublisher;
        }

        public void setCommentPublisher(String commentPublisher) {
            this.commentPublisher = commentPublisher;
        }

        public String getConmmentText() {
            return conmmentText;
        }

        public void setConmmentText(String conmmentText) {
            this.conmmentText = conmmentText;
        }

        public String getPicUrls() {
            return picUrls;
        }

        public void setPicUrls(String picUrls) {
            this.picUrls = picUrls;
        }
    }
}
