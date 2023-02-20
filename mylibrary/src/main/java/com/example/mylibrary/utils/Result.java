package com.example.mylibrary.utils;

import java.util.HashMap;
import java.util.Map;

public class Result {

    private Boolean success;

    private  Integer code;  // 除了HTTP状态码外我们还可以自己定义一些状态码;方便交互

    private  String message;

    private Map<String,Object> data = new HashMap<>();

    public Boolean getSuccess() {
        return success;
    }

    public void setSuccess(Boolean success) {
        this.success = success;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    private  Result() {} //把构造函数私有

    public  static Result ok() {
        Result r = new Result();
        r.setSuccess(true);
        r.setCode(200);
        r.setMessage("成功");
        return r;
    }

    public  static Result error() {
        Result r = new Result();
        r.setSuccess(false);
        r.setCode(204);
        r.setMessage("失败");
        return r;
    }

    public Result data(String key ,Object value) {
        this.data.put(key , value);
        return  this;  // 返回整个类对象
    }

    public Result data(Map<String,Object> map) {
        this.setData(map);
        return  this; // 返回整个类对象
    }

}
