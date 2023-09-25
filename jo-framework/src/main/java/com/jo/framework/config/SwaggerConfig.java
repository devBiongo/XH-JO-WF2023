package com.jo.framework.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

@Configuration
@EnableSwagger2
public class SwaggerConfig {

    /**
     * 配置 Swagger 的 Docket 的 Bean 实例
     * http://localhost:8080/swagger-ui.html
     */
    @Bean
    public Docket docket(ApiInfo apiInfo, Environment environment) {
        //设置要显示的Swagger环境
        Profiles profiles = Profiles.of("dev","test");
        //通过environment.acceptsProfiles()判断是否处在自己设定的环境中
        boolean enable = environment.acceptsProfiles(profiles);
        return new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo())
                .enable(enable)
                .select()
                /*
                 *RequestHandlerSelectors:配置要扫描接口的方式
                 * basePackage:指定要扫描的包
                 * any():扫描全部
                 * none():不扫描
                 * withClassAnnotation:扫描类上的注解，参数是一个注解的反射对象
                 * withMethodAnnotation:扫描方法上的注解
                 * */
                .apis(RequestHandlerSelectors.basePackage("com.jo.web.controller"))
                //过滤什么路径
                //.paths(PathSelectors.ant("/common/**"))
                .build();
    }

    @Bean
    public ApiInfo apiInfo() {
        //作者信息
        Contact contact =
                new Contact("Joffrey", "https://github.com/devBiongo", "bingo.dev@gmail.com");
        return new ApiInfo(
                "欣和シッピングシステム API",    //标题
                "Swagger测试",    //文档描述
                "v1.0",     //文档版本
                "https://github.com/devBiongo",     //队伍的网站地址
                contact,
                "Apache 2.0",   //许可证
                "http://www.apache.org/licenses/LICENSE-2.0",   //许可证URL
                new ArrayList<>()
        );
    }

}