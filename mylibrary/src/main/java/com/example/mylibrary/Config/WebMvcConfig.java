package com.example.mylibrary.Config;



import com.example.mylibrary.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {


    // 这个就是springboot中springMvc让程序开发者去配置文件上传的额外的静态资源服务的配置
//    @Override
//    public void addResourceHandlers(ResourceHandlerRegistry registry) {
//
//    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
       registry.addInterceptor(new LoginInterceptor()).addPathPatterns("/manage/**");
    }
}
