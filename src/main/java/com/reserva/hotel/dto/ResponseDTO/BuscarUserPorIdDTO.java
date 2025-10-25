package com.reserva.hotel.dto.ResponseDTO;

import com.reserva.hotel.model.Enum.UserRoleEnum;

public record BuscarUserPorIdDTO(Long id,
                                 String nome,
                                 String email,
                                 String senha,
                                 UserRoleEnum role) {
}
