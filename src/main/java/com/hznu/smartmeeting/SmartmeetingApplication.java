package com.hznu.smartmeeting;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication  //整个boot的核心注解，目的是开启boot的自动配置
@EnableTransactionManagement //启动注解事务管理，等同于xml配置方式<tx:annotation-driven/>
@EnableSwagger2
public class SmartmeetingApplication {

    public static void main(String[] args) {
        SpringApplication.run(SmartmeetingApplication.class, args);

        System.out.println("Application run finished!");
    }
}


