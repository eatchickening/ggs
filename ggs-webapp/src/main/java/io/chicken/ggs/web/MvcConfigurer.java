
package io.chicken.ggs.web;

import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfigurer extends WebMvcConfigurerAdapter {

    /**
     * 首页跳转
     * @param registry
     */
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("forward:/index.html");
        registry.setOrder(Ordered.HIGHEST_PRECEDENCE);
        super.addViewControllers(registry);
    }

    /**
     * 静态资源访问
     * @param registry
     */
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//        registry.addResourceHandler("swagger-ui.html")
//                .addResourceLocations("classpath:/swagger/");
//
//        registry.addResourceHandler("/webjars/**")
//                .addResourceLocations("classpath:/swagger/webjars/");
//
//        registry.addResourceHandler("/app/**").addResourceLocations("/app/");
//        super.addResourceHandlers(registry);
//    }

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

    //
    // @Override
    // public void configurePathMatch(PathMatchConfigurer configurer) {
    //     super.configurePathMatch(configurer);
    //     configurer.setUseSuffixPatternMatch(false);
    // }
}