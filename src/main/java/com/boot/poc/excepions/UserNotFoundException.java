package com.boot.poc.excepions;

public class UserNotFoundException extends Exception {
    String message;
    public UserNotFoundException(String msg) {
        super(msg);
        this.message=msg;
    }
}
