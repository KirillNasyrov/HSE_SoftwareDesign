package com.goodman.orderservice.exception;

public class IncorrectDishDataException extends RuntimeException {
    public IncorrectDishDataException(String message) {
        super(message);
    }
}
