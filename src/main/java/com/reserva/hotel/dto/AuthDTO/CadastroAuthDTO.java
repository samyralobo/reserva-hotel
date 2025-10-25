package com.reserva.hotel.dto.AuthDTO;

import com.reserva.hotel.model.Enum.UserRoleEnum;

public record CadastroAuthDTO(String nome,
                              String email,
                              String senha,
                              UserRoleEnum role) {
}
