package com.example.interceptorstudy.mapper;

import com.example.interceptorstudy.domain.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {

    @Select("select * from student;")
    public List<Student> SelectAll();
}
