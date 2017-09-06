
package io.chicken.ggs.web;

import org.springframework.boot.web.servlet.MultipartConfigFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import javax.servlet.MultipartConfigElement;

@Configuration
public class MvcConfigurer extends WebMvcConfigurerAdapter {

    /**
     * 首页跳转
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:app/src/index.html");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
    }

    /**
     * 静态资源访问
     * @param registry
     */
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/app/**").addResourceLocations("/app/");
        super.addResourceHandlers(registry);
    }

    /**
     * 跨域
     * @param registry
     */
    @Override
    public void addCorsMappings(CorsRegistry registry) {
        // registry.addMapping("/**").allowedOrigins("http://localhost:3000");
        registry.addMapping("/**").allowedOrigins("*");
        super.addCorsMappings(registry);
    }

    /**
     * 配置上传文件大小
     */
    // @Bean
    // public MultipartConfigElement multipartConfigElement() {
    //     MultipartConfigFactory factory = new MultipartConfigFactory();
    //     //文件最大
    //     factory.setMaxFileSize("10MB");
    //     //设置总上传数据总大小
    //     factory.setMaxRequestSize("20MB");
    //     return factory.createMultipartConfig();
    // }
}