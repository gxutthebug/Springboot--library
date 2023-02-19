package com.example.mylibrary.Mapper;

import com.example.mylibrary.domain.Order;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import java.util.List;

@Mapper
public interface OrderMapper {

    @Select(" select * from orders where seatid = #{seatid} and status = 0")
    public List<Order> selectOrderBySeat(String seatid);

    @Select(" select * from orders where stuid = #{stuid} and (status = 0 or status = 1)")
    public List<Order> selectOrderByStu(String stuid);

    @Update(" update orders set status=1 where orderid = #{orderid}")
    public void updatestatus1(int orderid);

    @Update("update orders set status=2 where orderid = #{orderid}")
    public void updatestatus2(int orderid);

    @Insert("insert into orders(seatid,stuid,createtime,starttime,endtime,status) values (#{seatid},#{stuid},#{createtime},#{starttime},#{endtime},#{status})")
    public void addOrder(Order order);
}
