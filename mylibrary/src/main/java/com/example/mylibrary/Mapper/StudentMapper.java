package com.example.mylibrary.Mapper;

import com.example.mylibrary.domain.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface StudentMapper {


    @Select(" select * from student where stuid = #{id}")
    public Student selectByStuId(String id);

    @Select("select * from student where stuusername = #{username}")
    public Student selectByusername(String username);
}
