package com.zzd.news.controller;

import com.alibaba.fastjson.JSON;
import com.zzd.news.msg.InfoResult;
import com.zzd.news.msg.LoginResult;
import com.zzd.news.msg.SuccessResult;
import com.zzd.news.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;
import java.io.IOException;
import java.util.Collection;


@Controller
public class UserController {
    @Autowired
    UserService userService;

    @ResponseBody
    @RequestMapping(value = "/dologin",method = RequestMethod.POST)
    public String userLogin(HttpServletRequest request){
        System.out.println(request);
        String code = request.getParameter("usercode");
        String password = request.getParameter("password");
        LoginResult result=userService.login(code,password);
        return JSON.toJSONString(result);
    }
    @ResponseBody
    @RequestMapping("/doregister")
    public String userRegister(HttpServletRequest request){
        System.out.println(request.toString());
        String code = request.getParameter("usercode");
        String password = request.getParameter("password");
        String username = request.getParameter("username");
        LoginResult result=userService.register(code,password,username);
        return JSON.toJSONString(result);
    }
    @ResponseBody
    @RequestMapping(value = "/dogetInfo",method = RequestMethod.POST)
    public String getUserInfo(HttpServletRequest request){
        System.out.println(request);
        String token_session = request.getParameter("token_session");
        InfoResult infoResult = userService.getInfo(token_session);
        return JSON.toJSONString(infoResult);
    }

    @ResponseBody
    @RequestMapping(value = "/doexit",method = RequestMethod.POST)
    public String exitLogin(HttpServletRequest request){
        System.out.println(request);
        String token_session = request.getParameter("token_session");
        LoginResult loginResult = userService.exitLogin(token_session);
        return JSON.toJSONString(loginResult);
    }

    @ResponseBody
    @RequestMapping(value = "/updatename",method = RequestMethod.POST)
    public String updateUsername(HttpServletRequest request){
        System.out.println(request);
        String token_session = request.getParameter("token_session");
        String username = request.getParameter("username");
        SuccessResult successResult = userService.updateUsername(token_session,username);
        System.out.println(JSON.toJSONString(successResult));
        return JSON.toJSONString(successResult);
    }
    @ResponseBody
    @RequestMapping(value = "/updatepwd",method = RequestMethod.POST)
    public String updateUserpwd(HttpServletRequest request){
        System.out.println(request);
        String token_session = request.getParameter("token_session");
        String userpwd = request.getParameter("userpwd");
        SuccessResult successResult = userService.updatePwd(token_session,userpwd);
        return JSON.toJSONString(successResult);
    }
}
