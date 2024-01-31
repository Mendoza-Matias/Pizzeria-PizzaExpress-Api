package com.mk.pizzaexpress.domain.exceptions;

public class StockException extends RuntimeException{
    public StockException(String message) {
        super(message);
    }
}
