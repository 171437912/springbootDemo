package com.example.demo.exception;

/**
 * 自定义异常
 *
 * @author lyk
 * @date 2018/12/7
 **/
public class CustomException extends RuntimeException {

    private int code;

    public CustomException() {
        super();
    }

    public CustomException(int code, String message) {
        super(message);
        this.setCode(code);
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

}
