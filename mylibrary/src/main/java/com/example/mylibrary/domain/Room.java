package com.example.mylibrary.domain;

public class Room {

    private String roomid;

    private String roomname;

    @Override
    public String toString() {
        return "Room{" +
                "roomid='" + roomid + '\'' +
                ", roomname='" + roomname + '\'' +
                ", isdel=" + isdel +
                '}';
    }

    private  int  isdel;

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }

    public String getRoomname() {
        return roomname;
    }

    public void setRoomname(String roomname) {
        this.roomname = roomname;
    }

    public int getIsdel() {
        return isdel;
    }

    public void setIsdel(int isdel) {
        this.isdel = isdel;
    }



}
