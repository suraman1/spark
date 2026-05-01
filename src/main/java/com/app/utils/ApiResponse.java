package com.app.utils;

public class ApiResponse {
    public String status;
    public String message;
    public Object data;
    public ApiResponse(String status, String message, Object data) {

        this.status = status;
        this.message = message;
        this.data = data;

    }
}
