package com.example.newsapp.pojo;

/**
 * @program: NewsApp
 * @description:
 * @author: zzd
 * @create: 2021-12-22 17:32
 **/
public class InfoResult {

    /**
     * code : 200
     * info : success
     * newsUser : {"tokenSession":"eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJwYXNzd29yZCI6IjY2NiIsImV4cCI6MTY0MDI2NjAwNywidXNlcm5hbWUiOiJhZG1pbiJ9.Zud4ffOQbud1tY_sAAslsBJMph5E5cUT9sk334fb7_o","tokenTime":1640086008000,"userCode":"admin","userId":1,"userName":"小王","userPassword":"fae0b27c451c728867a567e8c1bb4e53"}
     */

    private int code;
    private String info;
    private NewsUserBean newsUser;

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

    public NewsUserBean getNewsUser() {
        return newsUser;
    }

    public void setNewsUser(NewsUserBean newsUser) {
        this.newsUser = newsUser;
    }

    public static class NewsUserBean {
        /**
         * tokenSession : eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJwYXNzd29yZCI6IjY2NiIsImV4cCI6MTY0MDI2NjAwNywidXNlcm5hbWUiOiJhZG1pbiJ9.Zud4ffOQbud1tY_sAAslsBJMph5E5cUT9sk334fb7_o
         * tokenTime : 1640086008000
         * userCode : admin
         * userId : 1
         * userName : 小王
         * userPassword : fae0b27c451c728867a567e8c1bb4e53
         */

        private String tokenSession;
        private long tokenTime;
        private String userCode;
        private int userId;
        private String userName;
        private String userPassword;

        public String getTokenSession() {
            return tokenSession;
        }

        public void setTokenSession(String tokenSession) {
            this.tokenSession = tokenSession;
        }

        public long getTokenTime() {
            return tokenTime;
        }

        public void setTokenTime(long tokenTime) {
            this.tokenTime = tokenTime;
        }

        public String getUserCode() {
            return userCode;
        }

        public void setUserCode(String userCode) {
            this.userCode = userCode;
        }

        public int getUserId() {
            return userId;
        }

        public void setUserId(int userId) {
            this.userId = userId;
        }

        public String getUserName() {
            return userName;
        }

        public void setUserName(String userName) {
            this.userName = userName;
        }

        public String getUserPassword() {
            return userPassword;
        }

        public void setUserPassword(String userPassword) {
            this.userPassword = userPassword;
        }
    }
}
