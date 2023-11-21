package com.example.demo;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

// 对WebMvc进行一些配置,为swagger静态资源进行放行
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    // 静态资源放行
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {

        // 对swaggger静态资源放行
        registry.addResourceHandler("/doc.html").addResourceLocations("classpath:/META-INF/resources/");
        registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");

    }
}
