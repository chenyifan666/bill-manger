package com.cyf.billmanger.config;

import com.cyf.billmanger.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;


@Configuration
public class SpringMvcConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("main/index");
        registry.addViewController("/index").setViewName("main/index");
        registry.addViewController("/toLogin").setViewName("main/login");
        registry.addViewController("/provider/toAdd").setViewName("provider/add");
        registry.addViewController("/user/toAdd").setViewName("user/add");
        registry.addViewController("/password").setViewName("main/password");
    }
}
