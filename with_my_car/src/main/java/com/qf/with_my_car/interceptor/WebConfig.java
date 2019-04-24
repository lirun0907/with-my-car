package com.qf.with_my_car.interceptor;

import org.springframework.beans.factory.ListableBeanFactory;
import org.springframework.beans.factory.ObjectProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.http.HttpMessageConverters;
import org.springframework.boot.autoconfigure.web.ResourceProperties;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcAutoConfiguration;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.*;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Autowired
    private LoginInterceptor loginInterceptor;


    // 这个方法用来注册拦截器，我们自己写好的拦截器需要通过这里添加注册才能生效
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
//       registry.addInterceptor(loginInterceptor).excludePathPatterns("/login", "/regist","/index","/static/**");
        registry.addInterceptor(loginInterceptor).excludePathPatterns("/login", "/regist","/index","/js/**","/css/**","/bootstrap/**","/images/**","/datepicker/**");

//        registry.addInterceptor(loginInterceptor).addPathPatterns("/**").excludePathPatterns("/login", "/register");
//        WebMvcConfigurer.super.addInterceptors(registry);
//        InterceptorRegistration addInterceptor = registry.addInterceptor(loginInterceptor);
        // 拦截配置
//        addInterceptor.addPathPatterns("/**");
        // 排除配置
//        addInterceptor.excludePathPatterns("/static/**");//排除静态资源
//        addInterceptor.excludePathPatterns("/login");
//        addInterceptor.excludePathPatterns("/regist");
    }
    // 这个方法是用来配置静态资源的，比如html，js，css，等等
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
//        WebMvcConfigurer.super.addResourceHandlers(registry);
    }
}

