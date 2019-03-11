package com.sjy.springboot;

import com.sjy.springboot.interceptors.MyInterceptor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author sjy on 2019/3/11
 * @version 1.0
 */
@Configuration
public class MyWebConfigurerAdapter implements WebMvcConfigurer {
    private final static Logger logger = LoggerFactory.getLogger(MyWebConfigurerAdapter.class);


    @Bean
    public static HandlerInterceptor getHandlerInterceptor(){
        return new MyInterceptor();
    }

    //配置拦截器的url
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //addPathPatterns 用于添加拦截规则
//        //excludePathPatterns 用于排除拦截
        registry.addInterceptor(getHandlerInterceptor()).addPathPatterns("/user/**");

    }


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        logger.info("配置不拦截的静态资源");
////       registry.addResourceHandler("");
//        super.addResourceHandlers(registry);
    }
}
