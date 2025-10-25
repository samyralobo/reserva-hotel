package com.reserva.hotel.dto.RequestDTO;

import com.reserva.hotel.model.User;

import java.time.LocalDateTime;

public record ReservarQuartoDTO(LocalDateTime dataEntrada,
                                LocalDateTime dataSaida,
                                User user) {
}
