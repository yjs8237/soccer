package com.greatyun.soccer.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig  implements WebMvcConfigurer {
    @Autowired
    private AppInterceptor appInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(appInterceptor)
                .excludePathPatterns("/login/**" , "/join/**")

                .addPathPatterns("/kakaoss/**", "/manage/**")
                /*
                .excludePathPatterns("/static/**")
                .excludePathPatterns("/js/**")
                .excludePathPatterns("/css/**")
                .excludePathPatterns("/ajax/**")
                .excludePathPatterns("/admin/**")
                .excludePathPatterns("/user/login")
                 */
        ;
    }
}
