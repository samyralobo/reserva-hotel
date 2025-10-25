package com.reserva.hotel.Exception.CustomExceptions;

public class HotelExistenteException extends RuntimeException{
    public HotelExistenteException (String mensagem){
        super(mensagem);
    }
}
