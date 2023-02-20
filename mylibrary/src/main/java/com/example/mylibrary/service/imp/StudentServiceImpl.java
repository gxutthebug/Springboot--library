package com.example.mylibrary.service.imp;

import com.example.mylibrary.Mapper.StudentMapper;
import com.example.mylibrary.domain.Student;
import com.example.mylibrary.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StudentServiceImpl implements StudentService {

    @Autowired
    private StudentMapper studentMapper;

    @Override
    public Student selectByStuId(String id) {
        return studentMapper.selectByStuId(id);
    }

    @Override
    public Student selectByusername(String username) {
        return studentMapper.selectByusername(username);
    }

    @Override
    public void ResetPassword(String id, String newpassword) {
        studentMapper.ResetPassword(id , newpassword);
    }
}
