package com.oracle.cloudnote.intercepter;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class LoginedInterceptor implements HandlerInterceptor {
    private String[] paths = {"/user/login","/user/register", "/user/checkname"};
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
        System.out.println("执行了拦截器");
        String uri = request.getRequestURI();
        System.out.println(uri);
        for (String path : paths) {
            if (path.equals(uri))
                return true;
        }
        try {
            response.sendRedirect("/login.html");
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }
}