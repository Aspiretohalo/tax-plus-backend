package com.taxplus.taxplusbackend.config;

import com.taxplus.taxplusbackend.interceptor.OptionsInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
class InterceptorConfig implements WebMvcConfigurer {
    private static final String ALL = "/**";
    @Bean
    public OptionsInterceptor getOptionsInterceptor() {
        return new OptionsInterceptor();
    }
    /**
     * addInterceptor(拦截器)--> 将拦截器注册进来
     * addPathPatterns("url")--> 添加需要拦截的请求
     * excludePathPatterns("url")-->添加放行的请求，即不拦截
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getOptionsInterceptor()).addPathPatterns(ALL);
    }
}
