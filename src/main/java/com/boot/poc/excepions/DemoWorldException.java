package com.boot.poc.excepions;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.NOT_FOUND)
public class DemoWorldException extends RuntimeException {
    String message;
    public DemoWorldException(String s) {
        super(s);
        this.message=s;
    }
}
