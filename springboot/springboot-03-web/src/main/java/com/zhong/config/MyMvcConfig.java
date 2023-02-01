package com.zhong.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//这个类用来扩展mvc
@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/main.html").setViewName("dashboard");
        registry.addViewController("/main").setViewName("dashboard");
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        /*配置拦截器*/
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/index.html","/index","/","/user/login","/asserts/css/*","/asserts/js/**","/asserts/img/**");
    }
}
