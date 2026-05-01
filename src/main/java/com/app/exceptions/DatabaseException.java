package com.app.exceptions;

public class DatabaseException extends CustomException{
    public DatabaseException(String message) {
        super(500, message);
    }
}
