package com.reserva.hotel.dto.RequestDTO;

import com.reserva.hotel.model.HotelModel;
import com.reserva.hotel.model.ReservaModel;

import java.util.List;

public record UpdateQuartoDTO(Integer numero, Boolean disponivel,
                              HotelModel hotel, List<ReservaModel> reserva) {
}
