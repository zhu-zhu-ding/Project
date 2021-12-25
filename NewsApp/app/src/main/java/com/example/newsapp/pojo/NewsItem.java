package com.example.newsapp.pojo;

import java.util.List;

/**
 * @program: Food
 * @description:
 * @author: zzd
 * @create: 2021-11-24 16:25
 **/
public class NewsItem {

    /**
     * code : 200
     * info : success
     * msg : [{"newsId":1,"newsImg":"http://localhost:8086/picShow/pic.jpg,http://localhost:8086/picShow/pic.jpg,http://localhost:8086/picShow/pic.jpg","newsPublisher":"admin","newsText":"好看好看","newsTitle":"新闻1"}]
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
         * newsId : 1
         * newsImg : http://localhost:8086/picShow/pic.jpg,http://localhost:8086/picShow/pic.jpg,http://localhost:8086/picShow/pic.jpg
         * newsPublisher : admin
         * newsText : 好看好看
         * newsTitle : 新闻1
         */

        private int newsId;
        private String newsImg;
        private String newsPublisher;
        private String newsText;
        private String newsTitle;

        public int getNewsId() {
            return newsId;
        }

        public void setNewsId(int newsId) {
            this.newsId = newsId;
        }

        public String getNewsImg() {
            return newsImg;
        }

        public void setNewsImg(String newsImg) {
            this.newsImg = newsImg;
        }

        public String getNewsPublisher() {
            return newsPublisher;
        }

        public void setNewsPublisher(String newsPublisher) {
            this.newsPublisher = newsPublisher;
        }

        public String getNewsText() {
            return newsText;
        }

        public void setNewsText(String newsText) {
            this.newsText = newsText;
        }

        public String getNewsTitle() {
            return newsTitle;
        }

        public void setNewsTitle(String newsTitle) {
            this.newsTitle = newsTitle;
        }
    }
}
