package com.reserva.hotel.dto.ResponseDTO;

import java.time.LocalDateTime;

public record ListarReservasDTO(Long id,
                                LocalDateTime dataEntrada,
                                LocalDateTime dataSaida) {
}
