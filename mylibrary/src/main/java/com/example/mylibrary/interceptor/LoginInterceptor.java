package com.example.mylibrary.interceptor;

import com.example.mylibrary.utils.JwtUtils;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class LoginInterceptor implements HandlerInterceptor {

   @Override
   public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) {
       System.out.println(request);
       System.out.println("我是拦截器");

       return true;
    }
}
