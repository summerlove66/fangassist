package com.huido.fangassist.controller;


import com.huido.fangassist.model.Result;
import com.huido.fangassist.model.User;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
public class UserController {


    @RequestMapping("/user/login")
    public Result login(User user , HttpSession session , HttpServletResponse response) {
        response.addHeader("Access-Control-Allow-Origin", "*");
        if ("hd".equals(user.getUserName())) {
            session.setAttribute("verified",1);
            System.out.println(session +"SSSS");
            return new Result(1, "sucess", null);
        }
        return new Result(0, "用户名或密码错误", null);

    }



}

