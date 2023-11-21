package com.example.demo;

import com.github.xiaoymin.knife4j.spring.annotations.EnableKnife4j;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Swagger2配置类（生成接口文档）
 *
 * @author 白豆五
 * @version 2023/04/21
 * @since JDK8
 */
@Configuration
@EnableSwagger2 //开启swagger2注解支持
@EnableKnife4j  //开启Knife4j注解支持
public class SwaggerConfig{
    @Bean
    public Docket webApiConfig() { //生成接口文档的清单
        // 文档类型
        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("webApi")
                .apiInfo(webApiInfo())
                .select()
                //指定controller包扫描路径
                .apis(RequestHandlerSelectors.basePackage("com.baidou.controller"))
                .paths(PathSelectors.any())
                .build();
    }

    //配置在线api文档信息
    private ApiInfo webApiInfo() {
        return new ApiInfoBuilder()
                .title("网站-API文档")
                .description("本文档描述了xxx管理系统微服务接口定义")
                .version("1.0")
                .contact(new Contact("白豆五", "https://blog.csdn.net/qq_46921028", "13212341234@163.com"))
                .build();
    }
}