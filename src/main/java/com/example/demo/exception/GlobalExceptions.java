package com.example.demo.exception;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class GlobalExceptions extends RuntimeException{
    private HttpStatus status;

    public GlobalExceptions(String message, HttpStatus status) {
        super(message);
        this.status = status;
    }
}
