package com.reserva.hotel.dto.ResponseDTO;

import com.reserva.hotel.model.Embeddable.Endereco;

import java.util.List;

// we use LIST because we want not only one bedroom, but all of them
public record GetHotelByIdDTO(String nome,
                              Endereco endereco,
                              List<QuartoDTO> quartos) {
}
