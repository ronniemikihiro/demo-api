package com.example.demoapi.service.exception;

public class UserNotEnabledException extends RuntimeException {

    public UserNotEnabledException(String message) {
        super(message);
    }
}
