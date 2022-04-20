package com.portfolio.PortfolioAP.configs;

import com.portfolio.PortfolioAP.interceptors.JwtMiddleware;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer {

    @Autowired
    private JwtMiddleware jwtMiddleware;

    @Override
    public void addInterceptors(InterceptorRegistry registry){
        registry.addInterceptor(jwtMiddleware).addPathPatterns("/**/jwt/**");
    }
}
