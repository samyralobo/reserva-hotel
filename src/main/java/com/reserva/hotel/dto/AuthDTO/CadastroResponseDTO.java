package com.reserva.hotel.dto.AuthDTO;

import com.reserva.hotel.model.Enum.UserRoleEnum;

public record CadastroResponseDTO(Long id,
                                  String nome,
                                  String email,
                                  UserRoleEnum role) {
}
