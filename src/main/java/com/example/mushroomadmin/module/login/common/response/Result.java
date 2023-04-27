package com.example.mushroomadmin.module.login.common.response;

import java.io.Serializable;

/**
 * 返回数据的包装类
 * @author ting.xu
 * @date 2022-08-28 14:20
 */
public class Result<T> implements Serializable {
    private int code;
    private String msg;
    private T data;

    public Result() {
    }

    public Result(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
