package com.example.mylibrary.service;

import com.example.mylibrary.domain.Seat;


import java.util.List;

public interface SeatService {

    public List<Seat> selectSeatsByRoom(String roomid);
}
