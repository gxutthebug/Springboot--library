package com.mao.fileup.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebMvcConfig  implements WebMvcConfigurer {

    //    @Value("${file.uploadFolder}")
    private String uploadFolder;  // 定义一个属性
    //    @Value("${file.staticPath}")
    private String staticPath;


    // 这个就是springboot中springMvc让程序开发者去配置文件上传的额外的静态资源服务的配置
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/uploading/**").addResourceLocations("file:D:\\Springboot_static\\");

        //  "/uploading/**" 表示的是寻路径部分 ; "file:D:\\Springboot_static\\" 表示虚拟路径中的“**” 所要映射的盘符路径
        //   盘符路径的目录划分线是 “\”  ;而JAVA中的  “\”  要用 "\\" 表示
        //   但是盘符路径最终显示到浏览器上URL 又变回了虚拟路径 “/”
        //    即浏览器显示的URL中的 “/” 既可以表示虚拟路由中的下一层 ; 也可以表示盘符路径中的下一层
//        registry.addResourceHandler(staticPatternPath).addResourceLocations("file:"+uploadFolder);
    }
}
