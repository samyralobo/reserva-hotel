package com.reserva.hotel.dto;

import com.reserva.hotel.model.HotelModel;
import com.reserva.hotel.model.QuartoModel;

import java.time.LocalDateTime;

public record ListarReservasDTO(String nomeCliente, LocalDateTime dataEntrada,
                                LocalDateTime dataSaida, QuartoModel quarto, HotelModel hotel) {
}
