package com.reserva.hotel.dto.ResponseDTO;

import com.reserva.hotel.model.Enum.UserRoleEnum;
import com.reserva.hotel.model.User;

public record ListarUsuariosDTO(Long id,
                                String nome,
                                String email,
                                UserRoleEnum role) {
}
