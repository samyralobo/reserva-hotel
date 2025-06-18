package com.reserva.hotel.dto;

import com.reserva.hotel.model.QuartoModel;
import com.reserva.hotel.model.ReservaModel;

import java.util.List;

public record UpdateHotelDTO(Long id, String nomeHotel, String endereco,
                             List<QuartoModel> quartos, List<ReservaModel> reservas) {
}
