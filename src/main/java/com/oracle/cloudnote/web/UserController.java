package com.oracle.cloudnote.web;

import com.oracle.cloudnote.bean.Result;
import com.oracle.cloudnote.bean.User;
import com.oracle.cloudnote.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    //注册
    @RequestMapping("/register")
    public Object register(@Valid User user, BindingResult r){
        Result result = new Result();
        if(r.hasErrors()){//发现错误
            List<ObjectError> allErrors = r.getAllErrors();
            for (ObjectError error: allErrors){
                System.out.println(error.getDefaultMessage());
            }
            result.setSuccess(false);
            result.setMsg("格式不正确");
            result.setData(allErrors);
            return result;
        }
        boolean isSuccess = userService.register(user);
        if(!isSuccess){
            result.setMsg("用户名已存在");
            result.setSuccess(false);
        }
        return result;
    }
    //判断用户名是否存在
    @RequestMapping("/cheakname")
    public boolean checkname(String name){
        return userService.checkUsername(name);
    }

}
