package com.cyf.billmanger.config;

import com.cyf.billmanger.config.locale.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;

@Configuration
public class MySpringMvcConfiger {
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }
}
