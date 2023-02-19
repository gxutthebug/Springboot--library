package com.example.mylibrary.domain;

public class Seat {

    private String seatid;

    private String roomid;

    private int line;
    private int row;


    private int value;
    private int isDel;

    public String getSeatid() {
        return seatid;
    }

    public void setSeatid(String seatid) {
        this.seatid = seatid;
    }

    public String getRoomid() {
        return roomid;
    }

    public void setRoomid(String roomid) {
        this.roomid = roomid;
    }

    public int getLine() {
        return line;
    }

    public void setLine(int line) {
        this.line = line;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public int getIsDel() {
        return isDel;
    }

    public void setIsDel(int isDel) {
        this.isDel = isDel;
    }


    @Override
    public String toString() {
        return "Seat{" +
                "seatid='" + seatid + '\'' +
                ", roomid='" + roomid + '\'' +
                ", line=" + line +
                ", row=" + row +
                ", value=" + value +
                ", isDel=" + isDel +
                '}';
    }


}
