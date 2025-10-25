package com.reserva.hotel.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
@Table(name = "TB_QUARTO")
//        uniqueConstraints = {@UniqueConstraint(name = "UniqueNumeroHotel",
//        columnNames = {"numero", "hotel_id"})})
//the name of the columns have to be the same in the db, in "joinColumn" I put "hotel_id", so the name in
//uniqueConstraints has to be the same

public class QuartoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 100)
    private Integer numero;

    @Column(nullable = false)
    private Boolean disponivel;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private HotelModel hotel;

    @OneToMany(mappedBy = "quarto")
    private List<ReservaModel> reserva = new ArrayList<>();

}