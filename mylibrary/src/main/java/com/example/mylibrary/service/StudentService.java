package com.example.mylibrary.service;

import com.example.mylibrary.domain.Student;
import org.apache.ibatis.annotations.Select;


public interface StudentService {

    public Student selectByStuId(String id);

    public Student selectByusername(String username);

    public void ResetPassword (String id,String newpassword);
}
