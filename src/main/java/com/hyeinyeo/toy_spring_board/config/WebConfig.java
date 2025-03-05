package com.hyeinyeo.toy_spring_board.config;

import com.hyeinyeo.toy_spring_board.config.interceptor.LoginCheckInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new LoginCheckInterceptor())
                .order(1)
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/", "/register/**", "/login", "/logout", "/users/**", "/error/**",
                        "/check-duplicate-id",
                        "/css/**", "/*.ico", "/error", "/image/**", "/js/**"
                );
    }
}
