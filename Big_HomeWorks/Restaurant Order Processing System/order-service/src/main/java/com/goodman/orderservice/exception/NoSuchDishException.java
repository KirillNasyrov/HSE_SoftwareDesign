package com.goodman.orderservice.exception;

public class NoSuchDishException extends RuntimeException {
    public NoSuchDishException(String message) {
        super(message);
    }
}
