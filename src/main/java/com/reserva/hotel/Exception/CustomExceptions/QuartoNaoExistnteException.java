package com.reserva.hotel.Exception.CustomExceptions;

public class QuartoNaoExistnteException extends RuntimeException {
    public QuartoNaoExistnteException(String mensagem){
        super(mensagem);
    }
}
