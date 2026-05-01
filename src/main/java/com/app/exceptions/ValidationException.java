package com.app.exceptions;

public class ValidationException extends CustomException{

    public ValidationException(String message) {
        super(400, message);
    }
}
