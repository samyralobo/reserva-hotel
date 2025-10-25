package com.reserva.hotel.Exception.CustomExceptions;

public class HotelNaoEncontradoException extends RuntimeException {
    public HotelNaoEncontradoException (String mensagem){
        super(mensagem);
    }
}
