package com.example.interceptorstudy.domain;

public class Student {

    private String stuid;

    private String stusex;

    private String stuname;

    private String stuusername;



    private String stupassword;

    private String stucollege;

    private String stuclass;

    public String getStuid() {
        return stuid;
    }

    public void setStuid(String stuid) {
        this.stuid = stuid;
    }

    public String getStusex() {
        return stusex;
    }

    public void setStusex(String stusex) {
        this.stusex = stusex;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public String getStuusername() {
        return stuusername;
    }

    public void setStuusername(String stuusername) {
        this.stuusername = stuusername;
    }

    public String getStupassword() {
        return stupassword;
    }

    public void setStupassword(String stupassword) {
        this.stupassword = stupassword;
    }

    public String getStucollege() {
        return stucollege;
    }

    public void setStucollege(String stucollege) {
        this.stucollege = stucollege;
    }

    public String getStuclass() {
        return stuclass;
    }

    public void setStuclass(String stuclass) {
        this.stuclass = stuclass;
    }

    @Override
    public String toString() {
        return "Student{" +
                "stuid='" + stuid + '\'' +
                ", stusex='" + stusex + '\'' +
                ", stuname='" + stuname + '\'' +
                ", stuusername='" + stuusername + '\'' +
                ", stupassword='" + stupassword + '\'' +
                ", stucollege='" + stucollege + '\'' +
                ", stuclass='" + stuclass + '\'' +
                '}';
    }

}
