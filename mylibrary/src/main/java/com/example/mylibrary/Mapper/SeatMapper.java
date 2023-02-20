package com.example.mylibrary.Mapper;

import com.example.mylibrary.domain.Seat;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface SeatMapper {


    @Select("select * from seat where roomid = #{roomid}")
    public List<Seat> selectSeatsByRoom(String roomid);

    @Update("update seat set value=1  where seatid = #{seatid}")
    public  void  UpdateSeatValue(String seatid);

    @Update(" update seat set value=0 where seatid = #{seatid}")
    public  void  BackSeatValue(String seatid);
}
