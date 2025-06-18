package com.reserva.hotel.model;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

//@Data
//@NoArgsConstructor
//@AllArgsConstructor
//@Builder
@Entity
@Table(name = "TB_QUARTO")
public class QuartoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private Long numero;

    @Column(nullable = false)
    private Boolean disponivel;

    @ManyToOne
    @JoinColumn(name = "hotel_id")
    private HotelModel hotel;

    @OneToMany(mappedBy = "quarto", cascade = CascadeType.ALL)
    private List<ReservaModel> reserva = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getNumero() {
        return numero;
    }

    public void setNumero(Long numero) {
        this.numero = numero;
    }

    public Boolean getDisponivel() {
        return disponivel;
    }

    public void setDisponivel(Boolean disponivel) {
        this.disponivel = disponivel;
    }

    public HotelModel getHotel() {
        return hotel;
    }

    public void setHotel(HotelModel hotel) {
        this.hotel = hotel;
    }

    public List<ReservaModel> getReserva() {
        return reserva;
    }

    public void setReserva(List<ReservaModel> reserva) {
        this.reserva = reserva;
    }
}