package com.goodman.orderservice.exception;

public class InvalidDishChoiceException extends RuntimeException {
    public InvalidDishChoiceException(String message) {
        super(message);
    }
}
