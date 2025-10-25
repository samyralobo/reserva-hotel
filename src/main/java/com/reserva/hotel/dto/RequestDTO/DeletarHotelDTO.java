package com.reserva.hotel.dto.RequestDTO;

import com.reserva.hotel.model.Embeddable.Endereco;

public record DeletarHotelDTO(Long id, String nomeHotel, Endereco endereco) {
}
