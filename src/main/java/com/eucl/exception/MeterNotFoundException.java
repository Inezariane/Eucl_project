package com.eucl.exception;

public class MeterNotFoundException extends RuntimeException {
    public MeterNotFoundException(String message) {
        super(message);
    }
}
