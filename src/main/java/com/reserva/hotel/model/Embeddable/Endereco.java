package com.reserva.hotel.model.Embeddable;

import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Embeddable
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Endereco {
    private String rua;
    private String bairro;
    private String cep;
    private String complemento;
    private String cidade;
    private String estado;
}
