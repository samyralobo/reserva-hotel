package com.reserva.hotel.dto;

import com.reserva.hotel.model.HotelModel;
import com.reserva.hotel.model.ReservaModel;

import java.util.List;

public record ListarQuartosDTO(Long id, Long numero, Boolean disponivel,
                               HotelModel hotel, List<ReservaModel> reserva) {
}
