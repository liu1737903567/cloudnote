package com.oracle.cloudnote;

import com.oracle.cloudnote.intercepter.LoginedInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

public class CloudNoteConfig implements WebMvcConfigurer {
    @Autowired
    private LoginedInterceptor loginedInterceptor;
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(loginedInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/login.html")
                .excludePathPatterns("/styles/**")
                .excludePathPatterns("/scripts/**")
                .excludePathPatterns("/images/**")
                .excludePathPatterns("/alert/**")
                .excludePathPatterns("/fonts/**")
                .excludePathPatterns("/ico/**")
                .excludePathPatterns("/favicon.ico");
    }
}
