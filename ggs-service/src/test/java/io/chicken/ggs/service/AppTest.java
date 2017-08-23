package io.chicken.ggs.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * Unit test for simple App.
 */
@SpringBootApplication
@ComponentScan(basePackages ={"io.chicken.ggs"})
//mybatis路劲自动扫面
@MapperScan("io.chicken.ggs.dal")
//手动引入xml文件
// @ImportResource({"classpath:spring-bean.xml"})
public class AppTest {

    public static void main(String[] args) {
        SpringApplication.run(AppTest.class, args);
    }

}
