package com.mao.springboot0.controller;

import com.mao.springboot0.domain.Student;
import org.springframework.web.bind.annotation.*;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@RestController
public class testcontroller {

    @GetMapping("hello")
    public  String  helloword(){
         return "yfsenal";
    }

    @PostMapping("try")
    public Student aaa(Student stu  , String another)  {
        // x-www-form-urlencoded类型参数  对象接收测试

        System.out.println(another);
        System.out.println(stu);
        return stu;
    }

    @PostMapping("try2")
    public Student bbb(@RequestBody Student stu , String another){
  // application/json类型参数  接收测试
        System.out.println(another);  // null
        System.out.println(stu);
        System.out.println(stu.getTestarr().toString()); // [I@654a5785
        System.out.println(Arrays.toString(stu.getTestarr())); // [1, 2]
        return stu;
    }

    @PostMapping("try3")
    public List<String> ccc(@RequestParam List<String> aa) {  // 这里不加@RequestParam会报错
    // x-www-form-urlencoded类型参数  集合接收
        System.out.println(aa); //  ["yfm", "arsenal", "lalal"]
        return aa;  /* [
                       "\"yfm\"",
                       "\"arsenal\"",
                        "\"lalal\""]  返回去在前端接收到这玩意？？？*/
    }

    @PostMapping("try4")
    public String[] ddd(String[] aa) {
        // x-www-form-urlencoded类型参数  数组接收
//        String[] BB = {"YFM", "arsenal" ,"mancity"};
        System.out.println("666");
        System.out.println(Arrays.toString(aa)); // ["yfm", "arsenal", "lalal"]
        return aa;  /* [
                      "\"yfm\"",
                       "\"arsenal\"",
                        "\"lalal\""
                                     ]  返回去还是接到这玩意*/
    }
}



