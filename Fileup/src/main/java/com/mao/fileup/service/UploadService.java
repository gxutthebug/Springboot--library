package com.mao.fileup.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class UploadService {

//    @Value("${file.uploadFolder}")
    private String uploadFolder;  // 定义一个属性
//    @Value("${file.staticPath}")
    private String staticPath;


    public String uplodImg(MultipartFile multipartFile , String dir) {
        File targetFile = new File("D://Springboot_static/"+dir);
        try {
            if (!targetFile.exists()){
                targetFile.mkdir();  // 文件的放置路径(此时还差 最终的文件名 + 保存类型)
            }

            // 指定最终的文件放置点: 最终的文件放置点的路径要完完整整的指定到最终的文件名 + 保存类型
            File targetFileName =new File(targetFile,"aaa.png");

            multipartFile.transferTo(targetFileName);
            return "ok";
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }


    // 初步升级版!
    public Map<String,Object> uploadImgPro(MultipartFile multipartFile, String dir) {
        System.out.println("进来了");

        try {
            String realfilename = multipartFile.getOriginalFilename(); // 上传的文件：aaa.jpg
            System.out.println("①--"+realfilename); // ①--bug.txt

            // 2:截图文件名的后缀----multipartFile.getOriginalFilename()可以获取上传的原文件名,从原文件名中获取后缀
            String imgSuffix = realfilename.substring(realfilename.lastIndexOf("."));// 拿到：.jpg
            System.out.println("②--"+imgSuffix); // ②--.txt

            // 3:生成的唯一的文件名：能不能用中文名：不能因为统一用英文命名。
            //  生成随机数字符串 与 后缀名拼接 == 新的文件名
            String newFileName = UUID.randomUUID().toString()+imgSuffix;// 将aaa.jpg改写成：SD23423k324-23423ms.jpg
            System.out.println("③--"+newFileName); // ③--13af5d4f-33e9-45b0-bd89-c41f98df0c74.txt

            // 4：日期目录
            // 有了新的文件名,我们还想要在我们定义的父级目录 {dir} 下再细分出一些按上传日期划分的子级目录
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            String datePath = dateFormat.format(new Date());// 日期目录：2021/10/27
            System.out.println("④--"+datePath ); // ④--2023/02/18

            // 5: 指定文件上传以后的目录(此时还差 最终的文件名 + 保存类型)
            String servrepath = "D://Springboot_static/";// 这不是tomcat服务目录，别人不认识 , 所以要动态获取到tomcat运行目录把我们的文件搬进去
            File targetPath = new File(servrepath+dir,datePath);// 生成一个最终目录:F:D://Springboot_static/avatar/2021/10/27
            if(!targetPath.exists()){
                targetPath.mkdirs();  // 如果目录不存在：D://Springboot_static/avatar/2021/10/27 递归创建
                System.out.println("创建文件了");
                System.out.println("⑤--"+targetPath ); // ⑤--D:\Springboot_static\ TXT\2023\02\18
            }

            // 6: 指定最终的文件放置点
            File targetFileName = new File(targetPath,newFileName);// 文件上传以后在服务器上最终文件名和目录是：D://Springboot_static/avatar/2021/10/27/SD23423k324-23423ms.jpg

            // 7: 文件上传到指定的目录
            multipartFile.transferTo(targetFileName);//将用户选择的aaa.jpg上传到D://Springboot_static/avatar/2021/10/27/SD23423k324-23423ms.jpg

            // 可访问的路径要返回页面
            String filename = dir+"/"+datePath+"/"+newFileName;

            // 创建返回集合map
            Map<String,Object> map = new HashMap<>();
            map.put("url",filename);
            map.put("size",multipartFile.getSize());
            map.put("type",imgSuffix);
            map.put("filename",realfilename);



            return map;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("错啦");
            return null;
        }
    }





  // 升升级版!  就是把上面的指定盘符 "D://Springboot_static/" 和  虚拟映射路径"/uploading/**" 变成动态配置的 ------ 解耦
  // 把这两个玩意写到配置文件里 ,  然后用 @Value("") 再注入 , 实现解耦 ; 以后我们要改存储路径就直接改配置文件中的值即可
    public String uploadImgPro2(MultipartFile multipartFile, String dir) {
        try {
            String realfilename = multipartFile.getOriginalFilename(); // 上传的文件：aaa.jpg
            System.out.println("①--"+realfilename);

            // 2:截图文件名的后缀----multipartFile.getOriginalFilename()可以获取上传的原文件名,从原文件名中获取后缀
            String imgSuffix = realfilename.substring(realfilename.lastIndexOf("."));// 拿到：.jpg
            System.out.println("②--"+imgSuffix);

            // 3:生成的唯一的文件名：能不能用中文名：不能因为统一用英文命名。
            //  生成随机数字符串 与 后缀名拼接 == 新的文件名
            String newFileName = UUID.randomUUID().toString()+imgSuffix;// 将aaa.jpg改写成：SD23423k324-23423ms.jpg
            System.out.println("③--"+newFileName);

            // 4：日期目录
            // 有了新的文件名,我们还想要在我们定义的父级目录 {dir} 下再细分出一些按上传日期划分的子级目录
            SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd");
            String datePath = dateFormat.format(new Date());// 日期目录：2021/10/27
            System.out.println("④--"+datePath );

            // 5: 指定文件上传以后的目录(此时还差 最终的文件名 + 保存类型)
            String servrepath = uploadFolder;// 这不是tomcat服务目录，别人不认识 , 所以要动态获取到tomcat运行目录把我们的文件搬进去
            File targetPath = new File(servrepath+dir,datePath);// 生成一个最终目录:F://tmp/avatar/2021/10/27
            if(!targetPath.exists())targetPath.mkdirs(); // 如果目录不存在：F://tmp/avatar/2021/10/27 递归创建

            // 6: 指定最终的文件放置点
            File targetFileName = new File(targetPath,newFileName);// 文件上传以后在服务器上最终文件名和目录是：F://tmp/avatar/2021/10/27/SD23423k324-23423ms.jpg

            // 7: 文件上传到指定的目录
            multipartFile.transferTo(targetFileName);//将用户选择的aaa.jpg上传到F://tmp/avatar/2021/10/27/SD23423k324-23423ms.jpg

            // 可访问的路径要返回页面
            // http://localhpst:8777/bbs/2021/10/27/5f61dea2-4b77-4068-8d0b-fdf415eac6df.png
            String filename = dir+"/"+datePath+"/"+newFileName;
            return staticPath+"/upimages/"+filename;
        } catch (IOException e) {
            e.printStackTrace();
            return "fail";
        }
    }

}
