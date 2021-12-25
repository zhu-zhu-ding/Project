package com.zzd.news.service;


import com.zzd.news.msg.InfoResult;
import com.zzd.news.msg.LoginResult;
import com.zzd.news.msg.SuccessResult;
import com.zzd.news.pojo.NewsUser;

public interface UserService {
    NewsUser getUserByID(Integer id);
    String getPublisherByToken(String token);
    boolean judgeToken(String token);

    LoginResult login(String usercode, String password);

    LoginResult register(String code, String password,String username);

    InfoResult getInfo(String token_session);

    LoginResult exitLogin(String token_session);

    SuccessResult updateUsername(String token_session,String name);

    SuccessResult updatePwd(String token_session,String pwd);

}
