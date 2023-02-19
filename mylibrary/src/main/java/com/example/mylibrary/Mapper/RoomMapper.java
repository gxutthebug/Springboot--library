package com.example.mylibrary.Mapper;

import com.example.mylibrary.domain.Room;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RoomMapper {
    @Select(" select * from room")
    public List<Room> selectAllRoom();
}
