package com.mao.springboot0.controller;


import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;

@RestController
public class FileUploadController {


    @PostMapping("upload0")
    public  String up0(MultipartFile photo ){

        return "上传成功0";
    }




    @PostMapping("upload")
    // 三个参数分别接收: 用户的昵称(说明这里除文件外的一些其他属性也能接收) ; 用户上传过来的文件 ; 前端HTTP请求的上下文对象
    public String up(String nickname , MultipartFile photo , HttpServletRequest request) throws IOException{
        System.out.println(nickname);

        // 获取图片的原始名称
        System.out.println(photo.getOriginalFilename());

        //获取文件类型
        System.out.println(photo.getContentType());
//        System.out.println(System.getProperty("user.dir"));

        // 获取本WEB服务器的运行目录;因为这个程序最终是要部署到云端的LINUX上的(不在本地的tomcat),所以我们要动态的获取web服务器的运行根目录
        // 并且就算是本地服务器,每次的运行根目录也不会相同,每一次的运行目录都是idea为tomcat随机分配的一个本地目录,所以要想知道服务器运行目录就要动态获取
        // 但我们为什么要获取web服务器的运行根目录呢？
        // 因为我们在接收到前端上传的文件后要把文件保存到本地 / 云端 , 我们保存的位置要放在b服务器的运行的目录下 ,这样我们才能通过服务器的地址在浏览器访问到我们保存的东西
        String path = request.getServletContext().getRealPath("/upload/");

        // request.getServletContext()是动态获取路径 , getRealPath("/upload/")是动态拼接我们起的路径名 , 意思是在取web服务器的运行根目录(动态)创建一个子目录
        // 用来保存这个接口获取到的文件
        System.out.println(request.getServletContext());
        System.out.println(path);
        // 8080.后面那串随机数字就是idea为tomcat在本地分配的目录每次启动都会不同

        // 自定义一个方法把 该文件给存起来
        saveFile(photo,path);

        return "上传成功";
    }

    public void saveFile(MultipartFile photo ,String path) throws IOException{

        File dir = new File(path);  // 传入我们在上面获取与拼接得来那个路径名,生成一个File对象


        if( !dir.exists()){ // 利用这个对象判断该路径是否存在 ; 如果不存在就创建 ;我们准备在这个路径下保存接收到的文件
            dir.mkdir();
        }

        //  将接收到的文件 利用 photo.transferTo()保存到服务器上我们指定的目录
        // transferTo() 是 MultipartFile 接口的方法
        File file = new File( path+ photo.getOriginalFilename());
        photo.transferTo(file);
        // 弄到这里 , 文件接收了 , 也保存到服务器下了 , 但是现在还不能通过浏览器直接访问
        // 因为浏览器通过服务器地址只能访问默认暴露的静态资源........
    }

}
