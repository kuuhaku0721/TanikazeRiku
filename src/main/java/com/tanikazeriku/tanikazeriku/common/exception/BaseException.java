package com.tanikazeriku.tanikazeriku.common.exception;

/**
 * 业务异常 基类
 */
public class BaseException extends RuntimeException {

    public BaseException() {
    }

    public BaseException(String msg) {
        super(msg);
    }

}