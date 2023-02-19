package com.mao.springboot0.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class TemplateController {

    @GetMapping("aaa")
    public  String  any(){
        return  "arsenal";
    }
    /* 这个arsenal.html是放在/templates下的html模版
    想要被@Controller解析要添加依赖
    <dependency>
            <groupId>org.springframework.boot</groupId>
            <artifactId>spring-boot-starter-thymeleaf</artifactId>
        </dependency>
    添加后就能直接return html模版给浏览器渲染了
    * */

}
