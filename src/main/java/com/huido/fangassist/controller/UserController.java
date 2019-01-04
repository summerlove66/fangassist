package com.huido.fangassist.controller;


import com.huido.fangassist.model.Result;
import com.huido.fangassist.model.User;
import com.huido.fangassist.repository.UserRepository;
import com.huido.fangassist.utils.DateUtil;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Date;

@RestController
public class UserController {
    @Resource
    private UserRepository  userRepository;

    @RequestMapping("/user/login")
    public Result login(User loginUser , HttpSession session , HttpServletResponse response) {

        User  user =userRepository.findUserByUserName(loginUser.getUserName());
        Date deadline = user.getDeadline();
        if (!deadline.after(new Date())){
            return new Result(2,"该账号使用时间到期，请联系官方激活",null);
        }
        if(user.getRawPassword().equals( loginUser.getRawPassword())){

            return new Result(1,"success",null);
        }
        return new Result(0, "用户名或密码错误", null);

    }



    @RequestMapping("/user/register")
    public Result register(User user ){
        if (userRepository.findUserByUserName(user.getUserName()) ==null){
            Date curDate = new Date();
            user.setRegisterTime(curDate);
            user.setDeadline(DateUtil.addDay(curDate,7));
            userRepository.save(user);
           return  new Result(1,"success",null);
        }
            return  new Result(0, "用户名重复", null);
    }



}

