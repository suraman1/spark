package com.app.exceptions;

public class InvalidException extends Exception{
    public static int code;
    public static String message;
    public InvalidException(int code, String message) {
        this.code = code;
        this.message = message;
    }
}
