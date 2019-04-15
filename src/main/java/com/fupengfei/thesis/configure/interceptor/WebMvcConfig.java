package com.fupengfei.thesis.configure.interceptor;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class WebMvcConfig extends WebMvcConfigurationSupport {

    @Bean
    public TokenVaildInterceptor tokenVaildInterceptor() {
        return new TokenVaildInterceptor();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry
                .addInterceptor(tokenVaildInterceptor())
                .addPathPatterns("/v1/**");

        super.addInterceptors(registry);
    }
}
