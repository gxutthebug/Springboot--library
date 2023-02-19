package com.example.mylibrary.Controller;

import com.example.mylibrary.domain.Order;
import com.example.mylibrary.domain.Room;
import com.example.mylibrary.domain.Seat;
import com.example.mylibrary.service.imp.OrderServiceImpl;
import com.example.mylibrary.service.imp.RoomServiceImpl;
import com.example.mylibrary.service.imp.SeatServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RequestMapping("/search")
@RestController
@CrossOrigin
public class CommonController {

    @Autowired
    private SeatServiceImpl seatService;

    @Autowired
    private RoomServiceImpl roomService;

    @Autowired
    private OrderServiceImpl orderService;

    Map<String,Object> roomMap = new HashMap<>();  // 一个集合就是一个JS的纯属性对象，即一个{}里面没有方法!!!!!!
    Map<String,Object> dataMap = new HashMap<>();
    Map<String,Object> metaMap = new HashMap<>(); // 总的返回对象

    @GetMapping("/room") // 跟上面这行等效,只不过上面这行即可以发GET请求也可以发POST请求
    public List<Room> Room(){

        List<Room> rooms = roomService.selectAllRoom();

        System.out.println(rooms);

        return rooms;  // 操作返回结果为指定json数据（本质上是一个字符串信息）
    }


    @GetMapping("/seat")
    public List<Seat> Seats(String id){

        List<Seat> seats = seatService.selectSeatsByRoom(id);

        System.out.println(seats);

        return seats;  // 操作返回结果为指定json数据（本质上是一个字符串信息）
    }

    //POJO参数：请求参数与形参对象中的属性对应即可完成参数传递
    @PostMapping("/orders")
    public Order pojoParam(@RequestBody Order order){
        System.out.println("pojo参数传递 order ==> "+order);
        orderService.addOrder(order);
        return order;
    }

    @GetMapping("/orders")
    public List<Order> pojoParam(String seatid ){
        System.out.println("接收到的id是 ==> "+seatid);
        List<Order> orders= orderService.selectOrderBySeat(seatid);
        return orders;
    }


    @GetMapping("/myorders")
    public List<Order> myOrder(String stuid ){
        System.out.println("接收到的id是 ==> "+stuid);

        List<Order> orders= orderService.selectOrderByStu(stuid);

        return orders;
    }


    @GetMapping("/signin")
    public int signIn(int orderid ){
        System.out.println("接收到的id是 ==> "+orderid);

        orderService.updatestatus1(orderid);

        return orderid;
    }

    @GetMapping("/getout")
    public int  getOut(int orderid ){
        System.out.println("接收到的id是 ==> "+orderid);
        orderService.updatestatus2(orderid);
        return orderid;
    }



}
