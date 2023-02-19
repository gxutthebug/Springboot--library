package com.example.mylibrary.service.imp;

import com.example.mylibrary.Mapper.OrderMapper;
import com.example.mylibrary.domain.Order;
import com.example.mylibrary.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class OrderServiceImpl  implements OrderService {

    @Autowired
    private OrderMapper orderMapper;


    @Override
    public List<Order> selectOrderBySeat(String seatid) {
        return orderMapper.selectOrderBySeat(seatid);
    }

    @Override
    public List<Order> selectOrderByStu(String stuid) {
        return  orderMapper.selectOrderByStu(stuid);
    }

    @Override
    public void updatestatus1(int orderid) {
        orderMapper.updatestatus1(orderid);
    }

    @Override
    public void updatestatus2(int orderid) {
        orderMapper.updatestatus2(orderid);
    }

    @Override
    public void addOrder(Order order) {
        orderMapper.addOrder(order);
    }
}
