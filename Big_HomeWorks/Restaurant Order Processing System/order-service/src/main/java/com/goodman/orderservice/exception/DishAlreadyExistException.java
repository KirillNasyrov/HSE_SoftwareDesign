package com.goodman.orderservice.exception;

public class DishAlreadyExistException extends RuntimeException {
    public DishAlreadyExistException(String message) {
        super(message);
    }
}
