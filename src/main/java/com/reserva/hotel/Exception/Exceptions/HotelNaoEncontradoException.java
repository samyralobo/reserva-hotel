package com.reserva.hotel.Exception.Exceptions;

public class HotelNaoEncontradoException extends RuntimeException {
    public HotelNaoEncontradoException (String mensagem){
        super(mensagem);
    }
}
