package com.lyk.eduservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * @Author liyongkang
 * @Date 2022/8/12
 *
 * 主启动类
 **/
@SpringBootApplication
//扫描外部配置的注解，此处为了增加对swagger2的配置
@ComponentScan(basePackages = {"com.lyk"})
public class EduApplication {

    public static void main(String[] args) {
        SpringApplication.run(EduApplication.class, args);
    }

}
