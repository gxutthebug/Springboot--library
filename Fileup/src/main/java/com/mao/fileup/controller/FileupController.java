package com.mao.fileup.controller;

import com.mao.fileup.service.UploadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.HttpMediaTypeException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@RestController
public class FileupController {

    @Autowired
    private UploadService uploadService;


    @PostMapping("/upload/file")
    public Map<String,Object> upload(String dir , MultipartFile multipartFile , HttpServletRequest request) {

        System.out.println("?????");
        if(multipartFile.isEmpty()){
            Map<String,Object> map = new HashMap<>();
            map.put("massege","文件有误");
            return  map;
        }
        String originalFilename = multipartFile.getOriginalFilename();
        String contentType = multipartFile.getContentType();//imgae/png;image/jpg;image/gif
        System.out.println(request);
        System.out.println(contentType);
        System.out.println(originalFilename);
        /*可以在这里加一段文件类型的过滤逻辑*/

        System.out.println("?????");
        return uploadService.uploadImgPro(multipartFile,dir);
    }


    @PostMapping("/upload/file2")
    public String upload2(@RequestParam("file") MultipartFile multipartFile , HttpMediaTypeException request) {

        if(multipartFile.isEmpty()){
            return  "文件有误";
        }
        return "1";
    }
}

