package com.example.mylibrary.Mapper;

import com.example.mylibrary.domain.Seat;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface SeatMapper {

    @Select("select * from seat where roomid = #{roomid}")
    public List<Seat> selectSeatsByRoom(String roomid);


}
