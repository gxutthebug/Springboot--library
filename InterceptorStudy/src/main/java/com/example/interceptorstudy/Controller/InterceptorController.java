package com.example.interceptorstudy.Controller;

import com.example.interceptorstudy.domain.Student;
import com.example.interceptorstudy.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class InterceptorController {
    @Autowired
     private UserMapper userMapper;

    @GetMapping("user")
    public List<Student> hello(){
        System.out.println("123");
        List<Student>  list =  userMapper.SelectAll();;
        return list;
    }
}
