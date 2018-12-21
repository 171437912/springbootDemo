package com.example.demo.exception;

/**
 * 异常信息模板
 *
 * @author lyk
 * @date 2018/12/7
 **/
public class ErrorResponseEntity {

    private int code;

    private String message;


    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ErrorResponseEntity() {
    }

    public ErrorResponseEntity(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
