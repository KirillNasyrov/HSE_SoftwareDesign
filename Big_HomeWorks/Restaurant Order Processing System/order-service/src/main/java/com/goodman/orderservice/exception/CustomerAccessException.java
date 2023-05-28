package com.goodman.orderservice.exception;

public class CustomerAccessException extends RuntimeException {
    public CustomerAccessException(String message) {
        super(message);
    }
}
