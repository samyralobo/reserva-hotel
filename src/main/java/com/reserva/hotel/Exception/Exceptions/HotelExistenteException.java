package com.reserva.hotel.Exception.Exceptions;

public class HotelExistenteException extends RuntimeException{
    public HotelExistenteException (String mensagem){
        super(mensagem);
    }
}
