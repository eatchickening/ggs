package io.checken.ggs.service;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;

/**
 * Unit test for simple App.
 */
@SpringBootApplication
@ComponentScan(basePackages ={"io.checken.ggs"})
//mybatis路劲自动扫面
@MapperScan("io.checken.ggs.dal")
//手动引入xml文件
// @ImportResource({"classpath:spring-bean.xml"})
public class AppTest {

    public static void main(String[] args) {
        SpringApplication.run(AppTest.class, args);
    }

}
