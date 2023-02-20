package com.example.mylibrary.Mapper;

import com.example.mylibrary.domain.Manage;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

@Mapper
public interface ManageMapper {

    @Select(" select * from manage where mgename = #{id}")
    public Manage SelectBymgename(String id);
}
