package com.example.mushroomadmin.module.login.common.response;

/**
 * 返回数据的工具类
 * @author ting.xu
 * @date 2023-04-21 13:39
 */
public class ResultUtils {

    public static <T> Result success(){
        Result<T> result = new Result();
        result.setCode(200);
        result.setMsg("success");
        return result;
    }

    public static <T> Result success(T data){
        Result<T> result = new Result();
        result.setCode(200);
        result.setMsg("success");
        result.setData(data);
        return result;
    }

    public static <T> Result error(){
        Result<T> result = new Result();
        result.setCode(500);
        result.setMsg("error");
        return result;
    }

}
