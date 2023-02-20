package com.example.mylibrary.Mapper;

import com.example.mylibrary.domain.Student;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

@Mapper
public interface StudentMapper {


    @Select(" select * from student where stuid = #{id}")
    public Student selectByStuId(String id);

    @Select("select * from student where stuusername = #{username}")
    public Student selectByusername(String username);

    @Update("update student set stupassword=#{newpassword} where stuusername = #{id}")
    public void ResetPassword (String id,String newpassword);
}
