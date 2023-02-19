package com.example.mylibrary.service;

import com.example.mylibrary.domain.Order;


import java.util.List;

public interface OrderService {


    public List<Order> selectOrderBySeat(String seatid);

    public List<Order> selectOrderByStu(String stuid);

    public void updatestatus1(int orderid);

    public void updatestatus2(int orderid);

    public void addOrder(Order order);
}
