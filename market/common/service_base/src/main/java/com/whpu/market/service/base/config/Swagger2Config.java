package com.whpu.market.service.base.config;

import com.google.common.base.Predicates;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @author WorldYun
 * @since 2020/06/29
 */
@Configuration
@EnableSwagger2
public class Swagger2Config {

    @Bean
    public Docket webApiConfig(){
        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("user")
                .tags(new Tag("user","用户相关"), getTags())
                .apiInfo(webApiInfo())
                .select()
                .paths(Predicates.and(PathSelectors.regex("/api/.*")))
                .build();
    }

    private Tag[] getTags() {
        Tag[] tags = {
                new Tag("ucenter", "用户中心相关的API"),
                new Tag("supplier", "供应商管理相关的API"),
                new Tag("bill", "订单管理相关的API"),
        };
        return tags;
    }

//    @Bean
//    public Docket adminApiConfig(){
//        return new Docket(DocumentationType.SWAGGER_2)
//                .groupName("adminApi")
//                .apiInfo(adminApiInfo())
//                .select()
//                .paths(Predicates.and(PathSelectors.regex("/admin/.*")))
//                .build();
//    }

    private ApiInfo webApiInfo(){
        return new ApiInfoBuilder()
                .title("网站的API文档")
                .description("本文档描述了超市管理网站的api接口定义")
                .version("1.0")
                .contact(new Contact("WorldYun", "https://github.com/worldyun", "worldyun@qq.com"))
                .build();
    }

//    private ApiInfo adminApiInfo(){
//        return new ApiInfoBuilder()
//                .title("后台管理系统的API文档")
//                .description("本文档描述了谷粒学院后台管理系统的api接口定义")
//                .version("1.0")
//                .contact(new Contact("Helen", "http://atguigu.com", "55317332@qq.com"))
//                .build();
//    }
}
