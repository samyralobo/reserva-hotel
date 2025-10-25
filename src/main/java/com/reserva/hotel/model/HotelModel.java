package com.reserva.hotel.model;

import com.reserva.hotel.model.Embeddable.Endereco;
import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TB_HOTEL")
public class HotelModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 30)
    private String nomeHotel;

    @Embedded
    private Endereco endereco;

    @OneToMany(mappedBy = "hotel")
    private List<QuartoModel> quartos = new ArrayList<>();

}
