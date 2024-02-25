package com.milotnt.config;

import com.milotnt.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.ArrayList;
import java.util.List;

//处理拦截器注册
//@Configuration
public class LoginInterceptorConfigurer implements WebMvcConfigurer {
//         配置拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//        自定义拦截器对象
        HandlerInterceptor interceptor = new LoginInterceptor();
//        配置白名单,存放在一个List集合
        List<String> patterns = new ArrayList<>();
        patterns.add("/assets/**");
        patterns.add("/css/**");
        patterns.add("/img/**");
        patterns.add("/js/**");
        patterns.add("templates/adminLogin.html");
        patterns.add("/adminLogin");
//        拦截器的注册
        registry.addInterceptor(interceptor).addPathPatterns("/**")
                .excludePathPatterns(patterns);
        registry.addInterceptor(interceptor).excludePathPatterns("/adminLogin/**");
    }
}