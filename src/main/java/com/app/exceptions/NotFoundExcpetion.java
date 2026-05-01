package com.app.exceptions;

public class NotFoundExcpetion extends CustomException{

    public NotFoundExcpetion(String message) {
        super(404, message);
    }
}
