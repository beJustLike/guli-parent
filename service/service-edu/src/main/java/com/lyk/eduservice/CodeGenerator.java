package com.lyk.eduservice;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.rules.DateType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.junit.Test;

/**
 * @Author liyongkang
 * @Date 2022/8/12
 * <p>
 * Mybatis代码生成器
 **/
public class CodeGenerator {

    @Test
    public void codeGenerate() {

        //1. 创建代码生成器
        AutoGenerator autoGenerator = new AutoGenerator();

        //2. 全局配置

        GlobalConfig globalConfig = new GlobalConfig();

        //2.1 获取项目的绝对路径
        String absolutePath = System.getProperty("user.dir");

        //2.2 设置代码生成的目录
        globalConfig.setOutputDir(absolutePath + "/src/main/java");

        globalConfig.setAuthor("lyk");

        //2.3 设置代码生成后是否打开生成代码所在的目录
        globalConfig.setOpen(false);

        //2.4 去掉Service层的首字母I
        globalConfig.setServiceName("%sService");

        //2.5 主键生成策略：String类型
        globalConfig.setIdType(IdType.ID_WORKER_STR);

        //2.6 生成实体类中日期类型
        globalConfig.setDateType(DateType.ONLY_DATE);

        //2.7 开启swagger
        globalConfig.setSwagger2(true);

        autoGenerator.setGlobalConfig(globalConfig);

        //3. 数据源配置
        DataSourceConfig dataSourceConfig = new DataSourceConfig();

        dataSourceConfig.setDriverName("com.mysql.cj.jdbc.Driver");
        dataSourceConfig.setUrl("jdbc:mysql://localhost:3306/guli?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=Asia/Shanghai");
        dataSourceConfig.setUsername("root");
        dataSourceConfig.setPassword("root");
        dataSourceConfig.setDbType(DbType.MYSQL);

        autoGenerator.setDataSource(dataSourceConfig);

        //4. 包配置
        PackageConfig packageConfig = new PackageConfig();

        //4.1 设置模块名
        packageConfig.setModuleName("eduservice");

        //4.2 父包名
        packageConfig.setParent("com.lyk");

        //4.3 eduservice的子包
        packageConfig.setEntity("entity");
        packageConfig.setController("controller");
        packageConfig.setService("service");
        packageConfig.setMapper("mapper");

        autoGenerator.setPackageInfo(packageConfig);

        //5. 策略配置
        StrategyConfig strategyConfig = new StrategyConfig();

        //5.1 根据数据库中表的结构逆向生成代码
        strategyConfig.setInclude("edu_teacher");

        //5.2 数据库表映射到实体的命名策略（此处为下划线转驼峰）
        strategyConfig.setNaming(NamingStrategy.underline_to_camel);

        //5.3 生成实体时去掉表的前缀
        strategyConfig.setTablePrefix(packageConfig.getModuleName() + "_");

        //5.4 数据库表映射到实体的命名策略（此处为下划线转驼峰）
        strategyConfig.setColumnNaming(NamingStrategy.underline_to_camel);

        //5.5 开启lombok的set时链式操作
        strategyConfig.setEntityLombokModel(true);

        //5.6 开启Rest风格接口
        strategyConfig.setRestControllerStyle(true);

        //5.7 url中驼峰转连字符
        strategyConfig.setControllerMappingHyphenStyle(false);

        autoGenerator.setStrategy(strategyConfig);

        //6. 执行
        autoGenerator.execute();

    }

}
