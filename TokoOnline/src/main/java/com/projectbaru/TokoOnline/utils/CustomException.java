package com.projectbaru.TokoOnline.utils;

public class CustomException extends Exception {
    private Integer code;
    private String message;

    // Default Constructor
    public CustomException() {
    }
    // Constructor
    public CustomException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
    
    public Integer getCode() {
        return this.code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return this.message;
    }

    public void setMessage(String message) {
        this.message = message;
    }    
}
