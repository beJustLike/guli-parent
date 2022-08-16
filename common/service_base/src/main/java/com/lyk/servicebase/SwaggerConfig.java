package com.lyk.servicebase;

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
import springfox.documentation.swagger2.annotations.EnableSwagger2WebMvc;

/**
 * @Author liyongkang
 * @Date 2022/8/13
 * <p>
 * swagger配置类
 **/
@Configuration
@EnableKnife4j
@EnableSwagger2WebMvc
public class SwaggerConfig {

    @Bean
    public Docket webApiConfig() {

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("webApi")
                .apiInfo(webApiInfo())
                .select()
                //过滤掉admin目录下的所有文件
//                .paths(PathSelectors.regex("/admin/.*"))
                //过滤掉所有的error错误页面
//                .paths(PathSelectors.regex("/error.*"))
                .paths(PathSelectors.any())
                .apis(RequestHandlerSelectors.basePackage("com.lyk"))
                .build();

    }

    private ApiInfo webApiInfo() {

        return new ApiInfoBuilder()
                .title("网站-课程中心API文档")
                .description("本文档描述了课程中心微服务接口定义")
                .version("1.0")
                .contact(new Contact("lyk", "baidu.com", "lyk1005@outlook.com"))
                .build();
    }


}
