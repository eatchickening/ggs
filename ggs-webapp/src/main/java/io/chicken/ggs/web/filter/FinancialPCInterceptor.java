package io.chicken.ggs.web.filter;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 *
 * Created by wungmc on 2017/6/27.
 */
// @Configuration
public class FinancialPCInterceptor extends WebMvcConfigurerAdapter {

    // @Bean
    public AuthHandlerInterceptor getRedisService() {
        return new AuthHandlerInterceptor();
    }

    // @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getRedisService())
                .addPathPatterns(
                        "/**"
                )
                .excludePathPatterns(
                        "/ggs/auth/login",
                        "/app/**"
                );
    }
}
