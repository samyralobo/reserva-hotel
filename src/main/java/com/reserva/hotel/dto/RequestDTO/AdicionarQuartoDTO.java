package com.reserva.hotel.dto.RequestDTO;

import com.reserva.hotel.model.HotelModel;

public record AdicionarQuartoDTO(Integer numero,
                                 Boolean disponivel,
                                 HotelModel hotel) {
}
