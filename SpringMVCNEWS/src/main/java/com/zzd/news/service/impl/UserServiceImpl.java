package com.zzd.news.service.impl;

import com.alibaba.fastjson.JSON;
import com.zzd.news.TokenUtils;
import com.zzd.news.dao.NewsUserMapper;
import com.zzd.news.msg.InfoResult;
import com.zzd.news.msg.LoginResult;
import com.zzd.news.msg.SuccessResult;
import com.zzd.news.pojo.NewsUser;
import com.zzd.news.pojo.NewsUserExample;
import com.zzd.news.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private NewsUserMapper userMapper;
    @Override
    public NewsUser getUserByID(Integer id) {
        return userMapper.selectByPrimaryKey(id);
    }

    @Override
    public String getPublisherByToken(String token) {
        NewsUserExample newsUserExample = new NewsUserExample();
        NewsUserExample.Criteria criteria = newsUserExample.createCriteria();
        criteria.andTokenSessionEqualTo(token);
        return userMapper.selectByExample(newsUserExample).get(0).getUserName();
    }

    @Override
    public boolean judgeToken(String token) {
        NewsUserExample newsUserExample = new NewsUserExample();
        NewsUserExample.Criteria criteria = newsUserExample.createCriteria();
        criteria.andTokenSessionEqualTo(token);
        List<NewsUser> newsUsers = userMapper.selectByExample(newsUserExample);
        if(newsUsers.size()>=1){
            return true;
        }
        return false;
    }

    @Override
    public LoginResult login(String usercode, String password) {
        NewsUserExample newsUserExample = new NewsUserExample();
        NewsUserExample.Criteria criteria = newsUserExample.createCriteria();
        criteria.andUserCodeEqualTo(usercode);
        List<NewsUser> newsUsers = userMapper.selectByExample(newsUserExample);
        if(newsUsers.size()<1){
            return new LoginResult(301,"error","帐号不存在");
        }else if(DigestUtils.md5DigestAsHex(password.getBytes()).equals(newsUsers.get(0).getUserPassword())){
            criteria.andUserCodeEqualTo(usercode);
            Date date = new Date();
            userMapper.updateByExampleSelective(new NewsUser(null,null,null,null,TokenUtils.token(usercode,password),date),newsUserExample);
            return new LoginResult(200,"success", TokenUtils.token(usercode,password));
        } else {
            return new LoginResult(302,"error","密码错误");
        }
    }

    @Override
    public LoginResult register(String code, String password,String username) {
        NewsUserExample newsUserExample = new NewsUserExample();
        NewsUserExample.Criteria criteria = newsUserExample.createCriteria();
        criteria.andUserCodeEqualTo(code);
        List<NewsUser> newsUsers = userMapper.selectByExample(newsUserExample);
        if(newsUsers.size()>=1){
            return new LoginResult(303,"error","帐号已被注册");
        }else{
            userMapper.insert(new NewsUser(null,code,DigestUtils.md5DigestAsHex(password.getBytes()),username,null,null));
            return new LoginResult(200,"success", JSON.toJSONString(new NewsUser(null,code,password,username,null,null)));
        }
    }

    @Override
    public InfoResult getInfo(String token_session) {
        NewsUserExample newsUserExample = new NewsUserExample();
        NewsUserExample.Criteria criteria = newsUserExample.createCriteria();
        criteria.andTokenSessionEqualTo(token_session);
        List<NewsUser> newsUsers = userMapper.selectByExample(newsUserExample);
        if(newsUsers.size()>0){
            return new InfoResult(newsUsers.get(0));
        }else{
            return null;
        }
    }

    @Override
    public LoginResult exitLogin(String token_session) {
        NewsUserExample newsUserExample = new NewsUserExample();
        NewsUserExample.Criteria criteria = newsUserExample.createCriteria();
        criteria.andTokenSessionEqualTo(token_session);
        List<NewsUser> newsUsers = userMapper.selectByExample(newsUserExample);
        if(newsUsers.size()>0){
            userMapper.updateByExampleSelective(new NewsUser(null,null,null,null,"",null),newsUserExample);
            return new LoginResult(200,"success","退出成功");
        }else {
            return null;
        }
    }

    @Override
    public SuccessResult updateUsername(String token_session,String name) {
        NewsUserExample newsUserExample = new NewsUserExample();
        NewsUserExample.Criteria criteria = newsUserExample.createCriteria();
        criteria.andTokenSessionEqualTo(token_session);
        List<NewsUser> newsUsers = userMapper.selectByExample(newsUserExample);
        if(newsUsers.size()>0){
            userMapper.updateByExampleSelective(new NewsUser(null,null,null,name,null,null),newsUserExample);
            return new SuccessResult("success");
        }else {
            return null;
        }
    }

    @Override
    public SuccessResult updatePwd(String token_session,String pwd) {
        NewsUserExample newsUserExample = new NewsUserExample();
        NewsUserExample.Criteria criteria = newsUserExample.createCriteria();
        criteria.andTokenSessionEqualTo(token_session);
        List<NewsUser> newsUsers = userMapper.selectByExample(newsUserExample);
        if(newsUsers.size()>0){
            userMapper.updateByExampleSelective(new NewsUser(null,null,pwd,null,null,null),newsUserExample);
            return new SuccessResult("success");
        }else {
            return null;
        }
    }
}
