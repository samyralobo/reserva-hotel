package com.reserva.hotel.Exception.CustomExceptions;

public class QuartoNaoDisponivelException extends RuntimeException {
    public QuartoNaoDisponivelException(String message) {
        super(message);
    }
}
