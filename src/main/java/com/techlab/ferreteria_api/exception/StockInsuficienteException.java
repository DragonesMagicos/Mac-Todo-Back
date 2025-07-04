package com.techlab.ferreteria_api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

// Esta excepción se lanzará cuando se intente comprar más de lo que hay en stock [cite: 109]
@ResponseStatus(HttpStatus.BAD_REQUEST) // Responde con HTTP 400
public class StockInsuficienteException extends RuntimeException {
    public StockInsuficienteException(String message) {
        super(message);
    }
}