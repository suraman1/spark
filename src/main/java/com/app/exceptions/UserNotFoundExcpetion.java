package com.app.exceptions;

public class UserNotFoundExcpetion extends Exception{
    public static int code;
    public static String message;
    public UserNotFoundExcpetion(int code, String message) {
        this.code = code;
        this.message = message;
    }

}
