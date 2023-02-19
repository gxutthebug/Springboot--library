package com.example.mylibrary.service.imp;

import com.example.mylibrary.Mapper.RoomMapper;
import com.example.mylibrary.domain.Room;
import com.example.mylibrary.service.RoomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoomServiceImpl implements RoomService {
    @Autowired
    private RoomMapper roomMapper;


    @Override
    public List<Room> selectAllRoom() {

            return roomMapper.selectAllRoom();

    }
}
