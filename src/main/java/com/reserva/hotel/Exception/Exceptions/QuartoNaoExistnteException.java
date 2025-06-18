package com.reserva.hotel.Exception.Exceptions;

public class QuartoNaoExistnteException extends RuntimeException {
    public QuartoNaoExistnteException(String mensagem){
        super(mensagem);
    }
}
