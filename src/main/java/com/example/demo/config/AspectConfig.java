package com.example.demo.config;

import com.example.demo.aspect.LogsInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
public class AspectConfig {
    @Bean
    public LogsInterceptor userAspect(){
        return new LogsInterceptor();
    }
}
