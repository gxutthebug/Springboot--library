package com.example.mylibrary.Controller;

import com.example.mylibrary.service.imp.StudentServiceImpl;
import com.example.mylibrary.utils.JwtUtils;
import com.example.mylibrary.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;

@RestController
@CrossOrigin // 本地请求因为端口号不同,属于跨域请求需要打开跨域
public class Manage {

    @Autowired
    private StudentServiceImpl studentService;

    @PostMapping("/resetpassword")
    public Result resetpassword(String id, String newpassword, HttpServletRequest request) {

        String token = request.getHeader("Authorization");

            if(token == null) {
            return Result.error().data("result","没有token");
       }
                 try {  // 把载荷提取包裹在 try--catch中 ; 相当于在提取前验证该token是否有效
                     String username = JwtUtils.getClaimsByToken(token).getSubject();
                 } catch (Exception e) {
                     System.out.println(e);
                     return Result.error().data("result","token有误");
                 }


             studentService.ResetPassword(id,newpassword);




        return Result.ok().data("result","修改密码成功");
    }
}
