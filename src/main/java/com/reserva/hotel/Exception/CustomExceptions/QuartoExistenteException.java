package com.reserva.hotel.Exception.CustomExceptions;

public class QuartoExistenteException extends RuntimeException{
    public QuartoExistenteException(String mensagem){
        super(mensagem);
    }
}
