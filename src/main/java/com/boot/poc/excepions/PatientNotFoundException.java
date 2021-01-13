package com.boot.poc.excepions;

public class PatientNotFoundException extends Exception {
    String message;
    public PatientNotFoundException(String msg) {
        super(msg);
        this.message=msg;
    }
}

