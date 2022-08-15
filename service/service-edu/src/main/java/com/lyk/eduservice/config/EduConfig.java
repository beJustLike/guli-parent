package com.lyk.eduservice.config;

import com.baomidou.mybatisplus.core.injector.ISqlInjector;
import com.baomidou.mybatisplus.extension.injector.LogicSqlInjector;
import com.baomidou.mybatisplus.extension.plugins.PerformanceInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
/**
 * @Author liyongkang
 * @Date 2022/8/12
 *
 * 配置类，扫描mapper
 **/
@Configuration
@MapperScan("com.lyk.eduservice.mapper")
public class EduConfig {

    //SQL 执行性能分析插件。开发环境使用，线上不推荐。 maxTime 指的是 sql 最大执行时长
//    @Bean
//    @Profile({"dev","test"})
    public PerformanceInterceptor performanceInterceptor(){

        PerformanceInterceptor performanceInterceptor = new PerformanceInterceptor();
        //当sql执行时间超过10s后不执行
        performanceInterceptor.setMaxTime(10000);
        performanceInterceptor.setFormat(true);
        return performanceInterceptor;
    }

    //逻辑删除插件，只有注册了逻辑删除插件才能通过注解的方式实现逻辑删除功能
    @Bean
    public ISqlInjector sqlInjector(){
        return new LogicSqlInjector();
    }


}
