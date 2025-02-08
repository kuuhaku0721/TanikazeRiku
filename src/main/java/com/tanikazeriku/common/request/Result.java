package com.tanikazeriku.common.request;

import lombok.Data;
import java.io.Serializable;

@Data
public class Result<T> implements Serializable {
    private Integer code;
    private String msg = "info";
    private T data;

    public static <T> Result<T> success() {
        Result<T> result = new Result<T>();
        result.code = 200;
        return result;
    }

    public static <T> Result<T> success(T object) {
        Result<T> result = new Result<T>();
        result.data = object;
        result.code = 200;
        return result;
    }

    public static <T> Result<T> success(String msg, T data) {
        Result<T> result = new Result<T>();
        result.msg = msg;
        result.data = data;
        result.code = 200;
        return result;
    }

    public static <T> Result<T> error(String msg) {
        Result<T> result = new Result<T>();
        result.code = 500;
        result.msg = msg;
        return result;
    }

    public static <T> Result<T> error(String msg, T data) {
        Result<T> result = new Result<T>();
        result.code = 500;
        result.msg = msg;
        result.data = data;
        return result;
    }

    @Override
    public String toString() {
        return "Result{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                "}";
    }
}
