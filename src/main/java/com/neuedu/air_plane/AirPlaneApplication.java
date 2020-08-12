package com.neuedu.air_plane;

import com.neuedu.air_plane.interceptor.AuthInterceptor;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@SpringBootApplication
@MapperScan("com.neuedu.air_plane.dao")
public class AirPlaneApplication implements WebMvcConfigurer {

    public static void main(String[] args) {
        SpringApplication.run(AirPlaneApplication.class, args);
    }


    /**
     * 配置拦截规则
     * @param registry
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(new AuthInterceptor())
                .addPathPatterns("/**").excludePathPatterns("/api/login");
    }
}
