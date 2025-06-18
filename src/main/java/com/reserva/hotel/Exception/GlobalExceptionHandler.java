package com.reserva.hotel.Exception;

import com.reserva.hotel.Exception.Exceptions.HotelExistenteException;
import com.reserva.hotel.Exception.Exceptions.HotelNaoEncontradoException;
import com.reserva.hotel.Exception.Exceptions.QuartoExistenteException;
import com.reserva.hotel.Exception.Exceptions.QuartoNaoExistnteException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(HotelExistenteException.class)
    private ResponseEntity<String> hotelExistenteHnadler(HotelExistenteException exception){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
    }

    @ExceptionHandler(HotelNaoEncontradoException.class)
    private ResponseEntity<String> hotelNaoEncontradoHnadler (HotelNaoEncontradoException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }

    @ExceptionHandler(QuartoExistenteException.class)
    private ResponseEntity<String> quartoExistente(QuartoExistenteException exception){
        return ResponseEntity.status(HttpStatus.CONFLICT).body(exception.getMessage());
    }

    @ExceptionHandler(QuartoNaoExistnteException.class)
    private ResponseEntity<String> quartoNaoExistenteHandler(QuartoNaoExistnteException exception){
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
    }
}
