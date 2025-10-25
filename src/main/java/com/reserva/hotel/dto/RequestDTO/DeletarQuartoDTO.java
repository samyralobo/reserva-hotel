package com.reserva.hotel.dto.RequestDTO;

import com.reserva.hotel.model.HotelModel;

public record DeletarQuartoDTO(Long id, Integer numero, HotelModel hotel) {
}
