package com.reserva.hotel.dto.RequestDTO;

import com.reserva.hotel.model.Enum.UserRoleEnum;

public record CriarUsuarioDTO(Long id,
                              String nome,
                              String email,
                              String senha,
                              UserRoleEnum role) {
}
