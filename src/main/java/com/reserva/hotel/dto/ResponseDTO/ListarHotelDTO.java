package com.reserva.hotel.dto.ResponseDTO;

import com.reserva.hotel.model.Embeddable.Endereco;

public record ListarHotelDTO(Long id, String nomeHotel, Endereco endereco) {
}
