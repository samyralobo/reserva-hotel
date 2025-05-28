package com.reserva.hotel.model;

import jakarta.persistence.*;
import org.w3c.dom.ls.LSInput;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "TB_QUARTO")
public class QuartoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true, length = 100)
    private long numero;

    @Column(nullable = false)
    private boolean disponibilidade;

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

    public long getNumero() {
        return numero;
    }

    public void setNumero(long numero) {
        this.numero = numero;
    }

    public boolean isDisponibilidade() {
        return disponibilidade;
    }

    public void setDisponibilidade(boolean disponibilidade) {
        this.disponibilidade = disponibilidade;
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