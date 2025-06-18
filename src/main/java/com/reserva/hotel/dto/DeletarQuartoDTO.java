package com.reserva.hotel.dto;

import com.reserva.hotel.model.HotelModel;

public record DeletarQuartoDTO(Long id, Long numero, HotelModel hotel) {
}
