package com.example.mylibrary.domain;

public class Manage {

    private String mgename;

    private String password;

    private String sex;

    private String name;

    public String getMgename() {
        return mgename;
    }

    public void setMgename(String mgename) {
        this.mgename = mgename;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "Manage{" +
                "mgename='" + mgename + '\'' +
                ", password='" + password + '\'' +
                ", sex='" + sex + '\'' +
                ", name='" + name + '\'' +
                '}';
    }


}
