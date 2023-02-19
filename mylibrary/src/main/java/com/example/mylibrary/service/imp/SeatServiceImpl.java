package com.example.mylibrary.service.imp;

import com.example.mylibrary.Mapper.SeatMapper;

import com.example.mylibrary.domain.Seat;
import com.example.mylibrary.service.SeatService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SeatServiceImpl implements SeatService {

    @Autowired
    private SeatMapper seatMapper;


    @Override
    public List<Seat> selectSeatsByRoom(String roomid){
        return seatMapper.selectSeatsByRoom(roomid);
    }
}
