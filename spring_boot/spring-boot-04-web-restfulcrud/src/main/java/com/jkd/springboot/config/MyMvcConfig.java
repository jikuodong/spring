package com.jkd.springboot.config;

import com.jkd.springboot.component.LoginHandlerIntercepter;
import com.jkd.springboot.component.MyLocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

// 使用WebMvcConfigurerAdapter可以来扩展springMVC的功能
@Configuration
public class MyMvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
//        super.addViewControllers(registry);
        // 浏览器发送/jkd请求也来到success
        registry.addViewController("/jkd").setViewName("success");
    }

    @Bean
    public WebMvcConfigurerAdapter webMvcConfigurerAdapter() {
        WebMvcConfigurerAdapter webMvcConfigurerAdapter = new WebMvcConfigurerAdapter() {
            @Override
            public void addViewControllers(ViewControllerRegistry registry) {
                registry.addViewController("/").setViewName("login");
                registry.addViewController("/index.html").setViewName("login");
                registry.addViewController("/main.html").setViewName("dashboard");
            }

            // 注册拦截器
            @Override
            public void addInterceptors(InterceptorRegistry registry) {
//                super.addInterceptors(registry);
                // 静态资源；*.css， *.js
                // springboot已经做好了静态资源映射
                registry.addInterceptor(new LoginHandlerIntercepter()).addPathPatterns("/**").excludePathPatterns("/index.html","/","/user/login");
            }
        };
        return webMvcConfigurerAdapter;
    }
    @Bean
    public LocaleResolver localeResolver() {
        return new MyLocaleResolver();
    }
}
