package com.reserva.hotel.dto.RequestDTO;

import com.reserva.hotel.model.Embeddable.Endereco;

public record UpdateHotelDTO(String nomeHotel, Endereco endereco) {
}
