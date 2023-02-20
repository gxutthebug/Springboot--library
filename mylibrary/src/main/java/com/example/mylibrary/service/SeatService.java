package com.example.mylibrary.service;

import com.example.mylibrary.domain.Seat;
import com.example.mylibrary.domain.Student;


import java.util.List;

public interface SeatService {

    public List<Seat> selectSeatsByRoom(String roomid);

    public  void  UpdateSeatValue(String seatid);

    public  void  BackSeatValue(String seatid);
}
