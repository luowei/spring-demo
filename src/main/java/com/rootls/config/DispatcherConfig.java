package com.rootls.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfig;
import org.springframework.web.servlet.view.freemarker.FreeMarkerConfigurer;
import org.springframework.web.servlet.view.freemarker.FreeMarkerViewResolver;

/**
 * Created by luowei on 2014/4/25.
 */
@Configuration
@EnableWebMvc
@ComponentScan(basePackages = "com.rootls.controller")
public class DispatcherConfig {

    @Bean
    FreeMarkerConfig freeMarkerConfig(){
        FreeMarkerConfigurer freeMarkerConfigurer = new FreeMarkerConfigurer();
        freeMarkerConfigurer.setTemplateLoaderPath("/WEB-INF/views/");
        freeMarkerConfigurer.setDefaultEncoding("utf-8");
        return freeMarkerConfigurer;
    }

    @Bean
    ViewResolver viewResolver(){
        FreeMarkerViewResolver freeMarkerViewResolver = new FreeMarkerViewResolver();
        freeMarkerViewResolver.setSuffix(".ftl");
        freeMarkerViewResolver.setPrefix("");
        freeMarkerViewResolver.setCache(true);
        return freeMarkerViewResolver;
    }
}
